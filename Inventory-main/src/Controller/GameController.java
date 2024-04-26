package Controller;

import java.util.ArrayList;

import DataAccess.PlayerDataAccess;
import DataObjects.BoardDataObject;
import DomainObjects.GameTypeDomainObject;
import Models.GameTypeModel;
import Models.PlayerModel;
//import Models.GameTypeModel;
import restService.request.CreateGameRequest;
import restService.response.CreateGameResponse;
import restService.response.ItemTypeResponse;

public class GameController {

    // No GetAllItems in Connect 4

    /*
    public static ArrayList<ItemTypeResponse> getAllItemTypes () {
        //NOTE: This Method has not been explained in class yet.
        ArrayList<GameTypeDomainObject> domainList = GameTypeModel.GetAllItemTypes();
        ArrayList<ItemTypeResponse> responseList  = new ArrayList<ItemTypeResponse>();
       
        return responseList;

    }
    */

    public static CreateGameResponse CreateGame (CreateGameRequest request) {
        try {
            int player1Id = request.GetPlayer1Id();
            int player2Id = request.GetPlayer2Id();
            int gameTypeId = request.GetGameTypeId();
            
            boolean playerCheck = false;

            // Player 1 Exists
            // for (int i = 0; i < PlayerDataAccess.GetAllplayers().size(); i++) {
            //     if(player1Id == PlayerDataAccess.GetAllplayers().get(i).id){
            //         playerCheck = true;
            //     }
            // }

            // if(!playerCheck){
            //     throw new Exception ("Player does not exist");
            // }

            if(PlayerModel.GetplayerById(player1Id) == null){
                throw new Exception ("Player does not exist");
            }

            // Player 2 Exists
            // playerCheck = false;
            // for (int i = 0; i < PlayerDataAccess.GetAllplayers().size(); i++) {
            //     if(player2Id == PlayerDataAccess.GetAllplayers().get(i).id){
            //         playerCheck = true;
            //     }
            // }

            // if(!playerCheck){
            //     throw new Exception ("Player does not exist");
            // }

            if(PlayerModel.GetplayerById(player2Id) == null){
                throw new Exception ("Player does not exist");
            }

            // Game Type ID Valid
            if(GameTypeModel.GetItemTypeById(gameTypeId) == null){
                throw new Exception ("Game Type does not exist");
            }

            CreateGameResponse response = new CreateGameResponse(0, gameTypeId, player1Id, player2Id, player1Id, "Playing", -1, new BoardDataObject(0,0,0, ""));
            return response; 
        } catch (Exception ex) {
            CreateGameResponse response = new CreateGameResponse(ex.getMessage());
            return response; 
        }
    }





}