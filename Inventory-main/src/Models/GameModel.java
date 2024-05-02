package Models;

import java.util.ArrayList;

import DataAccess.GameDataAccess;
import DataObjects.GameDataObject;
import DomainObjects.GameDomainObject;
import restService.response.CreateGameResponse;

public class GameModel {

    public static GameDomainObject GetGameById(int id) {
        GameDataObject gameData = GameDataAccess.GetgameById(id);
        return new GameDomainObject(gameData);
    }

    public static ArrayList<GameDomainObject> GetAllgames() {
        ArrayList<GameDataObject> gameDataList = GameDataAccess.GetAllgames();
        return GameDomainObject.MapList(gameDataList);
    }

    public static GameDomainObject Addgame(GameDomainObject game){

        validategame(game);

        GameDataObject gameData = new GameDataObject(game);
        GameDataAccess.Addgame(gameData);
        return new GameDomainObject(gameData);
  
    }
    

    private static void validategame(GameDomainObject game) {
        
        try{
            if(PlayerModel.GetplayerById(game.Getplayer1Id()) == null){
                throw new Exception ("Player does not exist");
            }

            if(PlayerModel.GetplayerById(game.Getplayer2Id()) == null){
                throw new Exception ("Player does not exist");
            }

            // Game Type ID Valid
            if(GameTypeModel.GetGameTypeById(game.GetGameTypeId()) == null){
                throw new Exception ("Game Type does not exist");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }

    }

    public static void Save (GameDomainObject gameToSave) {
        GameDataObject GameDataObject = new GameDataObject(gameToSave);
        GameDataAccess.Save(GameDataObject);
    }
}
