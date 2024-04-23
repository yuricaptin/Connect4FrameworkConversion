package restService.response;


public class OrderResponse {

    private final boolean isValid;
    private final String errorMessage;
    
    private final int itemTypeId; 
    private final int gameId;
    private final int playerId;
    
    public OrderResponse (int itemTypeId, int gameId, int playerId) {
        this.itemTypeId = itemTypeId;
        this.gameId = gameId;
        this.playerId = playerId;
        this.isValid = true;
        this.errorMessage = null;
    }

    public OrderResponse (String errorMessage) {
        this.itemTypeId = -1;
        this.gameId = -1;
        this.playerId = -1;
        this.isValid = false;
        this.errorMessage = errorMessage;
    }


    public int GetItemTypeId() {
        return this.itemTypeId;
    }

    public int GetgameId() {
        return this.gameId;
    }

    public int GetplayerId() {
        return this.playerId;
    }

}
