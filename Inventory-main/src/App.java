import Controller.GameController;
import Controller.PlayerController;
import DataAccess.*;
import DataAccess.GameDataAccess;
import restService.request.*;
import restService.response.*;

public class App {
    public static void main(String[] args) throws Exception {

        initialize();

        RegisterPlayerRequest request = new RegisterPlayerRequest("Username", "Password");
        RegisterPlayerResponse response = PlayerController.RegisterPlayer(request);
        
        CreateGameRequest request2 = new CreateGameRequest(1,2,1);
        CreateGameResponse response2 = GameController.CreateGame(request2);

        CheckForWinnerRequest request3 = new CheckForWinnerRequest(1,2,1);
        CheckForWinnerResponse response3 = GameController.CheckForWinner(request3);

        System.out.println("Code is finished");
    }

    public static void initialize() {

    
        GameTypeDataAccess GameTypeDataAccess = new GameTypeDataAccess();
        PlayerDataAccess playerDataAccess = new PlayerDataAccess();
        GameDataAccess GameDataAccess = new GameDataAccess();
        BoardDataAccess BoardDataAccess = new BoardDataAccess();

    }
   
}
