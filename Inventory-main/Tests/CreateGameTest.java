import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Controller.GameController;
import DataAccess.BoardDataAccess;
import DataAccess.GameDataAccess;
import DataAccess.GameTypeDataAccess;
import DataAccess.PlayerDataAccess;
import restService.request.CreateGameRequest;
import restService.response.CreateGameResponse;

public class CreateGameTest {

    @Before
    public void initialize() {    
        GameTypeDataAccess GameTypeDataAccess = new GameTypeDataAccess();
        PlayerDataAccess PlayerDataAccess = new PlayerDataAccess();
        GameDataAccess GameDataAccess = new GameDataAccess();
        BoardDataAccess BoardDataAccess = new BoardDataAccess();
    }

    @Test
    public void GameController_CreateGame_Player1DoesNotExist() {
        int player1Id = 500;
        int player2Id = 2;
        int gameTypeId = 1;

        CreateGameRequest request = new CreateGameRequest(player1Id, player2Id, gameTypeId);
        CreateGameResponse response = GameController.CreateGame(request);

        assertEquals(false, response.GetSuccess());
    }

    @Test
    public void GameController_CreateGame_Player2DoesNotExist() {
        int player1Id = 1;
        int player2Id = 500;
        int gameTypeId = 1;

        CreateGameRequest request = new CreateGameRequest(player1Id, player2Id, gameTypeId);
        CreateGameResponse response = GameController.CreateGame(request);

        assertEquals(false, response.GetSuccess());
    }

    @Test
    public void GameController_CreateGame_GameTypeDoesNotExist() {
        int player1Id = 1;
        int player2Id = 2;
        int gameTypeId = 500;

        CreateGameRequest request = new CreateGameRequest(player1Id, player2Id, gameTypeId);
        CreateGameResponse response = GameController.CreateGame(request);

        assertEquals(false, response.GetSuccess());
    }

    @Test
    public void GameController_CreateGame_Success() {
        int player1Id = 1;
        int player2Id = 2;
        int gameTypeId = 1;

        CreateGameRequest request = new CreateGameRequest(player1Id, player2Id, gameTypeId);
        CreateGameResponse response = GameController.CreateGame(request);

        assertEquals(true, response.GetSuccess());
    }
    
}
