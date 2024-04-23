package DataObjects;

import DomainObjects.BoardDomainObject;

public class BoardDataObject {
    public final static String STATUS_AVAILABLE = "Available";
    public final static String STATUS_ORDERED = "Ordered";


    public int id; 
    public int itemTypeId; 
    public int gameId;
    public String status; 


    public BoardDataObject (int id, int itemTypeId, int gameId, String status) {
        this.id = id;
        this.itemTypeId = itemTypeId;
        this.gameId = gameId;
        this.status = status;
    }

    //Copy Constructor
    public BoardDataObject(BoardDataObject item) {
        this.id = item.id;
        this.itemTypeId = item.itemTypeId;
        this.gameId = item.gameId;
        this.status = item.status;
    }  

    public BoardDataObject (BoardDomainObject item) {
        this.id = item.GetId();
        this.itemTypeId = item.GetItemTypeId();
        this.gameId = item.GetgameId();
        this.status = item.GetStatus();
    }
}
