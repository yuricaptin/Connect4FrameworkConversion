package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DataAccess.PlayerDataAccess;
import DataObjects.PlayerDataObject;
import DomainObjects.PlayerDomainObject;
import Models.PlayerModel;
import restService.request.RegisterPlayerRequest;
import restService.response.RegisterPlayerResponse;

public class PlayerController {

    // Player Registration
    public static RegisterPlayerResponse RegisterPlayer (RegisterPlayerRequest request) {
        try {

            String username = request.GetUsername();
            String password = request.GetPassword();

            // Username            

            // Length
            if (!(username.length() >= 5 && username.length() <= 25)){
                throw new Exception ("Invalid Username.");
            }

            // Valid Characters
            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(username);
            if(m.find()){
                throw new Exception ("Invalid Username.");
            }

            // Unique
            for (int i = 0; i < PlayerDataAccess.GetAllplayers().size(); i++) {
                if(username.equals(PlayerDataAccess.GetAllplayers().get(i).username)){
                    throw new Exception ("Username is not unique.");
                }
            }

            // Password

            // Length
            if (!(password.length() >= 5 && password.length() <= 25)){
                throw new Exception ("Invalid Password.");
            }

            // Valid Characters
            m = p.matcher(password);
            if(m.find()){
                throw new Exception ("Invalid Password.");
            }            

            PlayerDomainObject playerToCreate = PlayerModel.Addplayer(new PlayerDomainObject(new PlayerDataObject(0, username, password)));

            RegisterPlayerResponse response = new RegisterPlayerResponse(playerToCreate.GetId(), username);
            return response;             
        } catch (Exception ex) {
            RegisterPlayerResponse response = new RegisterPlayerResponse(ex.getMessage());
            return response; 
        }
    }
}
