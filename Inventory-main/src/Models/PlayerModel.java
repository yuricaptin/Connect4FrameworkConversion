package Models;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DataAccess.PlayerDataAccess;
import DataObjects.PlayerDataObject;
import DomainObjects.PlayerDomainObject;
import restService.response.CreateGameResponse;

public class PlayerModel {

    public static PlayerDomainObject GetplayerById(int id) {
        PlayerDataObject playerData = PlayerDataAccess.GetplayerById(id);
        if (playerData == null) {
            return null;
        }
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
        // Username            
        try{
            // Length
            if (!(player.GetUsername().length() >= 5 && player.GetUsername().length() <= 25)){
                throw new Exception ("Invalid Username.");
            }

            // Valid Characters
            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(player.GetUsername());
            if(m.find()){
                throw new Exception ("Invalid Username.");
            }

            // Unique
            for (int i = 0; i < PlayerDataAccess.GetAllplayers().size(); i++) {
                if(player.GetUsername().equals(PlayerDataAccess.GetAllplayers().get(i).username)){
                    throw new Exception ("Username is not unique.");
                }
            }

            // Password

            // Length
            if (!(player.GetPassword().length() >= 5 && player.GetPassword().length() <= 25)){
                throw new Exception ("Invalid Password.");
            }

            // Valid Characters
            m = p.matcher(player.GetPassword());
            if(m.find()){
                throw new Exception ("Invalid Password.");
            }
            } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    public static void Save (PlayerDomainObject playerToSave) {
        PlayerDataObject PlayerDataObject = new PlayerDataObject(playerToSave);
        PlayerDataAccess.Save(PlayerDataObject);
    }

}
