package Models;

import java.util.ArrayList;

import DataAccess.GameDataAccess;
import DataObjects.GameDataObject;
import DomainObjects.GameDomainObject;

public class GameModel {

    public static GameDomainObject GetgameById(int id) {
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

    }

    public static void Save (GameDomainObject gameToSave) {
        GameDataObject GameDataObject = new GameDataObject(gameToSave);
        GameDataAccess.Save(GameDataObject);
    }
}
