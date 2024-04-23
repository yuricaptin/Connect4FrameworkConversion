package DomainObjects;

import java.util.ArrayList;

import DataObjects.GameTypeDataObject;

public class GameTypeDomainObject {
    
    private int id; 
    private String name; 


    public GameTypeDomainObject (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public GameTypeDomainObject (GameTypeDataObject itemType) {
        this.id = itemType.id;
        this.name = itemType.name;
    }

    public static ArrayList<GameTypeDomainObject> MapList(ArrayList<GameTypeDataObject> itemTypedata) {
        ArrayList<GameTypeDomainObject> itemTypeDomain = new ArrayList<GameTypeDomainObject>();
        for(GameTypeDataObject itemType : itemTypedata) {
            itemTypeDomain.add(new GameTypeDomainObject(itemType));
        }
        return itemTypeDomain;
    }


    public int GetId() {
        return this.id;
    }

    public String GetName() {
        return this.name;
    }


}
