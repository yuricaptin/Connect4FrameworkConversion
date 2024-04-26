package Models;

import java.util.ArrayList;

import DataAccess.BoardDataAccess;
import DataAccess.PlayerDataAccess;
import DataAccess.PlayerDataAccess;
import DataObjects.BoardDataObject;
import DataObjects.PlayerDataObject;
import DataObjects.PlayerDataObject;
import DomainObjects.BoardDomainObject;
import DomainObjects.PlayerDomainObject;
import DomainObjects.PlayerDomainObject;

public class PlayerModel {

    public static PlayerDomainObject GetplayerById(int id) {
        PlayerDataObject playerData = PlayerDataAccess.GetplayerById(id);
        return new PlayerDomainObject(playerData);
    }

    public static PlayerDomainObject GetAvailableplayer() {
        PlayerDataObject playerData = PlayerDataAccess.GetAvailableplayer();
        
        if (playerData == null) {
            return null;
        }

        return new PlayerDomainObject(playerData);
    }


    

    public static ArrayList<PlayerDomainObject> GetAllplayers() {
        ArrayList<PlayerDataObject> playerDataList = PlayerDataAccess.GetAllplayers();
        return PlayerDomainObject.MapList(playerDataList);
    }

    public static PlayerDomainObject Addplayer(PlayerDomainObject player){

        validateplayer(player);

        PlayerDataObject playerData = new PlayerDataObject(player);
        PlayerDataAccess.Addplayer(playerData);
        return new PlayerDomainObject(playerData);
  
    }
    

    private static void validateplayer(PlayerDomainObject player) {

    }

    public static void Save (PlayerDomainObject playerToSave) {
        PlayerDataObject PlayerDataObject = new PlayerDataObject(playerToSave);
        PlayerDataAccess.Save(PlayerDataObject);
    }

}
