package Controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DataAccess.PlayerDataAccess;
import DataObjects.BoardDataObject;
import DataObjects.PlayerDataObject;
import DomainObjects.BoardDomainObject;
import DomainObjects.GameDomainObject;
import DomainObjects.PlayerDomainObject;
import DomainObjects.GameDomainObject;
import Models.BoardModel;
import Models.PlayerModel;
import restService.request.RegisterPlayerRequest;
import restService.response.OrderResponse;
import restService.response.RegisterPlayerResponse;

public class PlayerController {
    // Order some item, 
    //    then retreive the list of games that have the item,
    //    then retreive the list of available players, 
    //    then assign the player to the game, 
    //    then assign the game to the player, 
    //    then return the appropriate OrderResponse

    //Order Item is not part of Connect 4

    /*
    public static OrderResponse OrderItem (OrderRequest request) {

        try {

            BoardDomainObject itemToRetreive = BoardModel.GetFirstAvailableByItemTypeId(request.GetItemTypeId());
            if (itemToRetreive == null) {
                throw new Exception ("No items to retreive.");
            }
            
            GameDomainObject playerToAssign = playerModel.GetAvailableplayer();
            if (playerToAssign == null) {
                throw new Exception ("No player available.");
            }

            int gameId = itemToRetreive.GetgameId();
            int playerId = playerToAssign.GetId();

            GameDomainObject gameToRetreive = itemToRetreive.Getgame();

            itemToRetreive.SetStatus(BoardDataObject.STATUS_ORDERED);
            playerToAssign.Setgame(gameId);
            gameToRetreive.Setplayer(playerId);


            OrderResponse response = new OrderResponse(request.GetItemTypeId(), gameId, playerId);
            return response;
        } catch (Exception ex) {
            OrderResponse response = new OrderResponse(ex.getMessage());
            return response; 
        }
    }
    */

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
                if(username.equals(PlayerDataAccess.GetAllplayers().get(i).name)){
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

            PlayerModel.Addplayer(new PlayerDomainObject(new PlayerDataObject(PlayerModel.GetAvailableplayer().GetId(), username)));

            RegisterPlayerResponse response = new RegisterPlayerResponse(0, username);
            return response;             
        } catch (Exception ex) {
            RegisterPlayerResponse response = new RegisterPlayerResponse(ex.getMessage());
            return response; 
        }
    }
}
