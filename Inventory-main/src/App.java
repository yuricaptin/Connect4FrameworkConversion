import Controller.OrderController;
import DataAccess.*;
import restService.request.OrderRequest;
import restService.response.OrderResponse;

public class App {
    public static void main(String[] args) throws Exception {

        initialize();


        OrderRequest request = new OrderRequest(1);
        OrderResponse response = OrderController.OrderItem(request);

        OrderRequest request2 = new OrderRequest(1);
        OrderResponse response2 = OrderController.OrderItem(request2);

        OrderRequest request3 = new OrderRequest(1);
        OrderResponse response3 = OrderController.OrderItem(request3);


        System.out.println("Code is finished");
    }

    public static void initialize() {
        GameTypeDataAccess GameTypeDataAccess = new GameTypeDataAccess();
        GameDataAccess GameDataAccess = new GameDataAccess();
        GameDataAccess GameDataAccess = new GameDataAccess();
        BoardDataAccess BoardDataAccess = new BoardDataAccess();

    }
   
}
