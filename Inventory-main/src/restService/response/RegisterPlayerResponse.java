package restService.response;

public class RegisterPlayerResponse {
    private final int playerId;
    private final String username;

    private final boolean success;
    private final String errorMessage;    
    
    public RegisterPlayerResponse (int playerId, String username) {
        this.playerId = playerId;
        this.username = username;
        this.success = true;
        this.errorMessage = null;
    }

    public RegisterPlayerResponse (String errorMessage) {
        this.playerId = 0;
        this.username = null;
        this.success = false;
        this.errorMessage = errorMessage;
    }

    public int GetplayerId() {
        return this.playerId;
    }

    public String GetUsername() {
        return this.username;
    }

}
