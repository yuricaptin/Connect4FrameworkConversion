package Models;

import java.util.ArrayList;

import DataAccess.BoardDataAccess;
import DataAccess.Boart;
import DataObjects.BoardDataObject;
import DataObjects.GameDataObject;
import DomainObjects.BoardDomainObject;
import DomainObjects.GameDomainObject;

public class PlayerModel {

    public static GameDomainObject GetplayerById(int id) {
        GameDataObject playerData = Boart.GetplayerById(id);
        return new GameDomainObject(playerData);
    }

    public static GameDomainObject GetAvailableplayer() {
        GameDataObject playerData = Boart.GetAvailableplayer();
        
        if (playerData == null) {
            return null;
        }

        return new GameDomainObject(playerData);
    }


    

    public static ArrayList<GameDomainObject> GetAllplayers() {
        ArrayList<GameDataObject> playerDataList = Boart.GetAllplayers();
        return GameDomainObject.MapList(playerDataList);
    }

    public static GameDomainObject Addplayer(GameDomainObject player){

        validateplayer(player);

        GameDataObject playerData = new GameDataObject(player);
        Boart.Addplayer(playerData);
        return new GameDomainObject(playerData);
  
    }
    

    private static void validateplayer(GameDomainObject player) {

    }

    public static void Save (GameDomainObject playerToSave) {
        GameDataObject GameDataObject = new GameDataObject(playerToSave);
        Boart.Save(GameDataObject);
    }

}
