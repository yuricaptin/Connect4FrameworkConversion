package Models;

import java.util.ArrayList;

import DataAccess.BoardDataAccess;
import DataObjects.BoardDataObject;
import DomainObjects.BoardDomainObject;

public class ItemModel {

    public static BoardDomainObject GetItemById(int id) {
        BoardDataObject itemData = BoardDataAccess.GetItemById(id);
        return new BoardDomainObject(itemData);
    }

    public static BoardDomainObject GetFirstAvailableByItemTypeId(int itemTypeId) {
        BoardDataObject itemData = BoardDataAccess.GetFirstAvailableByItemTypeId(itemTypeId);
        
        if (itemData == null) {
            return null;
        }

        return new BoardDomainObject(itemData);
    }

    public static ArrayList<BoardDomainObject> GetAllItems() {
        ArrayList<BoardDataObject> itemDataList = BoardDataAccess.GetAllItems();
        return BoardDomainObject.MapList(itemDataList);
    }

    public static ArrayList<BoardDomainObject> GetItemsByItemTypeId(int id) {
        ArrayList<BoardDataObject> itemDataList = BoardDataAccess.GetItemsByItemTypeId(id );
        return BoardDomainObject.MapList(itemDataList);
    }

    public static BoardDomainObject AddItem(BoardDomainObject item){

        validateItem(item);

        BoardDataObject itemData = new BoardDataObject(item);
        BoardDataAccess.AddItem(itemData);
        return new BoardDomainObject(itemData);
  
    }
    

    private static void validateItem(BoardDomainObject item) {

    }


    public static void Save (BoardDomainObject itemToSave) {
        BoardDataObject BoardDataObject = new BoardDataObject(itemToSave);
        BoardDataAccess.Save(BoardDataObject);
    }
  


}
