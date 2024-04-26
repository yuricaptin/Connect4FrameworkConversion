import Controller.GameController;
import Controller.OrderController;
import Controller.PlayerController;
import DataAccess.*;
import restService.request.CreateGameRequest;
import restService.request.OrderRequest;
import restService.request.RegisterPlayerRequest;
import restService.response.CreateGameResponse;
import restService.response.OrderResponse;
import restService.response.RegisterPlayerResponse;

public class App {
    public static void main(String[] args) throws Exception {

        initialize();

        RegisterPlayerRequest request = new RegisterPlayerRequest("Username", "Password");
        RegisterPlayerResponse response = PlayerController.RegisterPlayer(request);
        
        CreateGameRequest request2 = new CreateGameRequest(1,2,1);
        CreateGameResponse response2 = GameController.CreateGame(request2);


        // OrderRequest request = new OrderRequest(1);
        // OrderResponse response = OrderController.OrderItem(request);

        // OrderRequest request2 = new OrderRequest(1);
        // OrderResponse response2 = OrderController.OrderItem(request2);

        // OrderRequest request3 = new OrderRequest(1);
        // OrderResponse response3 = OrderController.OrderItem(request3);


        System.out.println("Code is finished");
    }

    public static void initialize() {
        GameTypeDataAccess GameTypeDataAccess = new GameTypeDataAccess();
        GameDataAccess GameDataAccess = new GameDataAccess();
        GameDataAccess GameDataAccess = new GameDataAccess();
        BoardDataAccess BoardDataAccess = new BoardDataAccess();

    }
   
}
