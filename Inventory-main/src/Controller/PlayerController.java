package Controller;

import java.util.ArrayList;

import DataObjects.BoardDataObject;
import DomainObjects.BoardDomainObject;
import DomainObjects.GameDomainObject;
import DomainObjects.GameDomainObject;
import Models.BoardModel;
import Models.playerModel;
import restService.request.OrderRequest;
import restService.response.OrderResponse;

public class PlayerController {
    // Order some item, 
    //    then retreive the list of games that have the item,
    //    then retreive the list of available players, 
    //    then assign the player to the game, 
    //    then assign the game to the player, 
    //    then return the appropriate OrderResponse
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
}
