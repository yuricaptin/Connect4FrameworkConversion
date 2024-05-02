import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Controller.GameController;
import DataAccess.BoardDataAccess;
import DataAccess.GameDataAccess;
import DataAccess.GameTypeDataAccess;
import DataAccess.PlayerDataAccess;
import restService.request.CheckForWinnerRequest;
import restService.response.CheckForWinnerResponse;

public class CheckForWinnerTest {

    @Before
    public void initialize() {    
        GameTypeDataAccess GameTypeDataAccess = new GameTypeDataAccess();
        PlayerDataAccess PlayerDataAccess = new PlayerDataAccess();
        GameDataAccess GameDataAccess = new GameDataAccess();
        BoardDataAccess BoardDataAccess = new BoardDataAccess(); 
    }

    @Test
    public void GameController_CheckForWinner_ColumnTooLow() {
        int gameId = 1;
        int playerId = 1;
        int column = -1;
        // Column value of 0 is now accepted because counting starts from 0 in code.
        // In order to be out of range (1-7 -> 0-6), I changed the column to -1 contrary to the sprint plan.

        CheckForWinnerRequest request = new CheckForWinnerRequest(gameId, playerId, column);
        CheckForWinnerResponse response = GameController.CheckForWinner(request);

        assertEquals(false, response.GetSuccess());
    }

    @Test
    public void GameController_CheckForWinner_ColumnTooHigh() {
        int gameId = 1;        
        int playerId = 1;
        int column = 8;        

        CheckForWinnerRequest request = new CheckForWinnerRequest(gameId, playerId, column);
        CheckForWinnerResponse response = GameController.CheckForWinner(request);

        assertEquals(false, response.GetSuccess());
    }

    @Test
    public void GameController_CheckForWinner_Success() {
        int gameId = 2;
        // Game ID is 2 contrary to the sprint plan, 
        // so I can test the winner check by initializing it with a board that has a win state.
        // Change board in BoardDataAccess to test win check
        int playerId = 1;
        int column = 1;

        CheckForWinnerRequest request = new CheckForWinnerRequest(gameId, playerId, column);
        CheckForWinnerResponse response = GameController.CheckForWinner(request);

        assertEquals(true, response.GetSuccess());
    }    
}
