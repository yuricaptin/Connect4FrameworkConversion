package restService.response;

public class CheckForWinnerResponse {
    private final int gameId;
    private final String status;
    private final int winner;
    private final boolean success;
    private final String errorMessage;

    public CheckForWinnerResponse (int gameId, String status, int winner) {
        this.gameId = gameId;
        this.status = status; // Completed
        this.winner = winner;
        this.success = true;
        this.errorMessage = null;
    }

    public CheckForWinnerResponse (String errorMessage) {
        this.gameId = 0;
        this.status = "Playing";
        this.winner = 0;
        this.success = false;
        this.errorMessage = errorMessage;
    }

    public int GetGameId () {
        return this.gameId;
    }

    public String GetStatus () {
        return this.status;
    }

    public int GetWinner () {
        return this.winner;
    }

    public boolean GetSuccess() {
        return this.success;
    }
}
