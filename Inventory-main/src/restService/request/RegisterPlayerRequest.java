package restService.request;

public class RegisterPlayerRequest {
    private final String username;
    private final String password; 
    
    public RegisterPlayerRequest (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String GetUsername() {
        return this.username;
    }

    public String GetPassword() {
        return this.username;
    }

}
