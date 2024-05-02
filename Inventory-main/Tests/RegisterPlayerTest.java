import Controller.PlayerController;
import DataAccess.BoardDataAccess;
import DataAccess.GameDataAccess;
import DataAccess.GameTypeDataAccess;
import DataAccess.PlayerDataAccess;
import restService.request.RegisterPlayerRequest;
import restService.response.RegisterPlayerResponse;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class RegisterPlayerTest {

    @Before
    public void initialize() {    
        GameTypeDataAccess GameTypeDataAccess = new GameTypeDataAccess();
        PlayerDataAccess PlayerDataAccess = new PlayerDataAccess();
        GameDataAccess GameDataAccess = new GameDataAccess();
        BoardDataAccess BoardDataAccess = new BoardDataAccess();
    }

    @Test
    public void PlayerController_RegisterPlayer_UsernameTooShort() {
        String username = "yo";
        String password = "password";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        RegisterPlayerResponse response = PlayerController.RegisterPlayer(request);

        assertEquals(false, response.GetSuccess());
    }

    @Test
    public void PlayerController_RegisterPlayer_UsernameTooLong() {
        String username = "lolyouactuallycheckedthelength";
        String password = "password";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        RegisterPlayerResponse response = PlayerController.RegisterPlayer(request);

        assertEquals(false, response.GetSuccess());
    }

    @Test
    public void PlayerController_RegisterPlayer_UsernameInvalidChars() {
        String username = "##yo##";
        String password = "password";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        RegisterPlayerResponse response = PlayerController.RegisterPlayer(request);

        assertEquals(false, response.GetSuccess());
    }

    @Test
    public void PlayerController_RegisterPlayer_UsernameNotUnique() {
        String username = "username1";
        String password = "password";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        RegisterPlayerResponse response = PlayerController.RegisterPlayer(request);

        assertEquals(false, response.GetSuccess());
    }    

    @Test
    public void PlayerController_RegisterPlayer_PasswordTooShort() {
        String username = "username";
        String password = "yo";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        RegisterPlayerResponse response = PlayerController.RegisterPlayer(request);

        assertEquals(false, response.GetSuccess());
    }

    @Test
    public void PlayerController_RegisterPlayer_PasswordTooLong() {
        String username = "username";
        String password = "lolyouactuallycheckedthelength";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        RegisterPlayerResponse response = PlayerController.RegisterPlayer(request);

        assertEquals(false, response.GetSuccess());
    }

    @Test
    public void PlayerController_RegisterPlayer_PasswordInvalidChars() {
        String username = "username";
        String password = "##yo##";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        RegisterPlayerResponse response = PlayerController.RegisterPlayer(request);

        assertEquals(false, response.GetSuccess());
    }

    @Test
    public void PlayerController_RegisterPlayer_Success() {
        String username = "username";
        String password = "password";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        RegisterPlayerResponse response = PlayerController.RegisterPlayer(request);

        assertEquals(true, response.GetSuccess());
    }
}
