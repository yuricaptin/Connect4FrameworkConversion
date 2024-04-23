package DataAccess;

import java.util.ArrayList;
import DataObjects.GameTypeDataObject;

public class GameTypeDataAccess {

    private static ArrayList<GameTypeDataObject> itemTypes = new ArrayList<GameTypeDataObject>();
    private static int nextId = 0;  

    public GameTypeDataAccess() {
        initialize();
    }

    private void initialize() {
        itemTypes.add(new GameTypeDataObject(0, "Thumb Drive"));
        itemTypes.add(new GameTypeDataObject(1, "Mouse"));
        nextId = 2;

    }

    private static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }

    public static ArrayList<GameTypeDataObject> GetAllItemTypes() {
        ArrayList<GameTypeDataObject> itemTypesList = new ArrayList<GameTypeDataObject>();
        //Create a copy of itemTypes to return.
        for (GameTypeDataObject itemType: itemTypes) {
            itemTypesList.add(new GameTypeDataObject(itemType));
        }
        return itemTypesList;
    }

    public static GameTypeDataObject GetItemTypeById(int id) {
        for( GameTypeDataObject itemType : itemTypes) {
            if (itemType.id == id) {
                return new GameTypeDataObject(itemType);
            }
        }
        return null;
    }

    public static GameTypeDataObject AddItemType(GameTypeDataObject newItemType) {
        newItemType.id = getNextId(); 
        itemTypes.add(newItemType);
        return newItemType;
    }

}
