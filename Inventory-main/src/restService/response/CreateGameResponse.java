package restService.response;

import DataObjects.BoardDataObject;

public class CreateGameResponse {
    private final int gameId;
    private final int gameTypeId;
    private final int player1Id;
    private final int player2Id;
    private final int currentTurnPlayer;
    private final String status;
    private final int winner;
    private final BoardDataObject board;
    private final boolean success;
    private final String errorMessage;

    public CreateGameResponse (int gameId, int gameTypeId, int player1Id, int player2Id, int currentTurnPlayer, String status, int winner, BoardDataObject board) {
        this.gameId = gameId;
        this.gameTypeId = gameTypeId;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.currentTurnPlayer = currentTurnPlayer;
        this.status = status;
        this.winner = winner;
        this.board = board;
        this.success = true;
        this.errorMessage = null;
    }

    public CreateGameResponse (String errorMessage) {
        this.gameId = 0;
        this.gameTypeId = 0;
        this.player1Id = 0;
        this.player2Id = 0;
        this.currentTurnPlayer = 0;
        this.status = null;
        this.winner = 0;
        this.board = null;
        this.success = false;
        this.errorMessage = errorMessage;
    }

    public int GetGameId () {
        return this.gameId;
    }

    public int GetGameTypeId () {
        return this.gameTypeId;
    }

    public int player1Id () {
        return this.player1Id;
    }

    public int player2Id () {
        return this.player2Id;
    }

    public int currentTurnPlayer () {
        return this.currentTurnPlayer;
    }

    public String GetStatus () {
        return this.status;
    }

    public int GetWinner () {
        return this.winner;
    }

    public BoardDataObject GetBoard () {
        return this.board;
    }

    public boolean GetSuccess() {
        return this.success;
    }
}
