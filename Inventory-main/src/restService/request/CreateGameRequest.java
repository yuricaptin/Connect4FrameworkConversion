package restService.request;

public class CreateGameRequest {
    private int player1Id;
    private int player2Id;
    private int gameTypeId;
    
    public CreateGameRequest (int player1Id, int player2Id, int gameTypeId) {
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.gameTypeId = gameTypeId;
    }

    public int GetPlayer1Id() {
        return this.player1Id;
    }

    public int GetPlayer2Id() {
        return this.player2Id;
    }

    public int GetGameTypeId() {
        return this.gameTypeId;
    }
}
