package Models;

import java.util.ArrayList;

import DataAccess.GameTypeDataAccess;
import DataObjects.GameTypeDataObject;
import DomainObjects.GameTypeDomainObject;


public class GameTypeModel {
    public static GameTypeDomainObject GetItemTypeById(int id) {
        GameTypeDataObject itemTypeData = GameTypeDataAccess.GetItemTypeById(id);
        return new GameTypeDomainObject(itemTypeData);
    }

    public static ArrayList<GameTypeDomainObject> GetAllItemTypes() {
        ArrayList<GameTypeDataObject> itemTypeDataList = GameTypeDataAccess.GetAllItemTypes();
        return GameTypeDomainObject.MapList(itemTypeDataList);
    }

    public static GameTypeDomainObject AddItemType(GameTypeDomainObject itemType){

        validateItemType(itemType);

        GameTypeDataObject itemTypeData = new GameTypeDataObject(itemType);
        GameTypeDataAccess.AddItemType(itemTypeData);
        return new GameTypeDomainObject(itemTypeData);
  
    }
    

    private static void validateItemType(GameTypeDomainObject itemType) {

    }



}
