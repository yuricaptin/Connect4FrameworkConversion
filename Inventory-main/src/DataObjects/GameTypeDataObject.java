package DataObjects;

import DomainObjects.GameTypeDomainObject;

public class GameTypeDataObject {
    
    public int id; 
    public String name; 


    public GameTypeDataObject (int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Copy Constructor
    public GameTypeDataObject(GameTypeDataObject itemType) {
        this.id = itemType.id;
        this.name = itemType.name;
    }   
    

    public GameTypeDataObject (GameTypeDomainObject itemType) {
        this.id = itemType.GetId();
        this.name = itemType.GetName();
    }
}
