package Controller;

import java.util.ArrayList;

import DomainObjects.GameTypeDomainObject;
import Models.GameTypeModel;
import restService.response.ItemTypeResponse;

public class GameController {

    public static ArrayList<ItemTypeResponse> getAllItemTypes () {
        //NOTE: This Method has not been explained in class yet.

        ArrayList<GameTypeDomainObject> domainList = GameTypeModel.GetAllItemTypes();
        ArrayList<ItemTypeResponse> responseList  = new ArrayList<ItemTypeResponse>();
       
        return responseList;

    }





}