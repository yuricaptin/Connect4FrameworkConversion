package restService.request;

import DomainObjects.GameDomainObject;

public class CheckForWinnerRequest {
    private int gameId;
    private int playerId;
    private int column;
    
    public CheckForWinnerRequest (GameDomainObject game) {
        this.gameId = game.GetId();
        this.playerId = game.Getplayer1Id(); // update to current turn player
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
