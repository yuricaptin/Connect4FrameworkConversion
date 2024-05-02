package restService.request;

public class CheckForWinnerRequest {
    private int gameId;
    private int playerId;
    private int column;
    
    public CheckForWinnerRequest (int gameId, int playerId, int column) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.column = column;
    }

    public int GetGameId() {
        return this.gameId;
    }

    public int GetPlayerId() {
        return this.playerId;
    }

    public int GetColumn() {
        return this.column;
    }
}
