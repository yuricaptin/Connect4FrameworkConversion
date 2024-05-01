package Controller;

import java.util.ArrayList;

import DataAccess.PlayerDataAccess;
import DataObjects.BoardDataObject;
import DataObjects.GameDataObject;
import DomainObjects.GameDomainObject;
import DomainObjects.GameTypeDomainObject;
import Models.GameModel;
import Models.GameTypeModel;
import Models.PlayerModel;
//import Models.GameTypeModel;
import restService.request.CreateGameRequest;
import restService.response.CreateGameResponse;
import restService.response.ItemTypeResponse;

public class GameController {

    public static CreateGameResponse CreateGame (CreateGameRequest request) {
        try {
            int player1Id = request.GetPlayer1Id();
            int player2Id = request.GetPlayer2Id();
            int gameTypeId = request.GetGameTypeId();

            if(PlayerModel.GetplayerById(player1Id) == null){
                throw new Exception ("Player does not exist");
            }

            if(PlayerModel.GetplayerById(player2Id) == null){
                throw new Exception ("Player does not exist");
            }

            // Game Type ID Valid
            if(GameTypeModel.GetGameTypeById(gameTypeId) == null){
                throw new Exception ("Game Type does not exist");
            }

            GameModel.Addgame(new GameDomainObject(new GameDataObject(0,gameTypeId)));

            CreateGameResponse response = new CreateGameResponse(0, gameTypeId, player1Id, player2Id, player1Id, "Playing", -1, new BoardDataObject(new String[6][7], 0,0,0, ""));
            return response; 
        } catch (Exception ex) {
            CreateGameResponse response = new CreateGameResponse(ex.getMessage());
            return response; 
        }
    }

    // public static CreateGameResponse CheckForWinner (CreateGameRequest request) {
        
    // }
}