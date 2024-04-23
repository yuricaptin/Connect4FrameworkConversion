package DomainObjects;

import java.util.ArrayList;

import DataObjects.BoardDataObject;
import Models.BoardModel;
import Models.GameTypeModel;
import Models.GameModel;

public class BoardDomainObject {
    
    private int id; 
    private int itemTypeId;
    private int gameId; 
    private String status;

    private GameTypeDomainObject itemType; 
    private GameDomainObject game;

    public BoardDomainObject (int id, int itemTypeId, int gameId, String status) {
        this.id = id;
        this.itemTypeId = itemTypeId;
        this.gameId = gameId;
        this.status = status;
    }

    public BoardDomainObject (BoardDataObject item) {
        this.id = item.id;
        this.itemTypeId = item.itemTypeId;
        this.gameId = item.gameId;
        this.status = item.status;
    }

    public static ArrayList<BoardDomainObject> MapList(ArrayList<BoardDataObject> itemdata) {
        ArrayList<BoardDomainObject> itemDomain = new ArrayList<BoardDomainObject>();
        for(BoardDataObject item : itemdata) {
            itemDomain.add(new BoardDomainObject(item));
        }
        return itemDomain;
    }

    public int GetId() {
        return this.id;
    }

    public int GetItemTypeId() {
        return this.itemTypeId;
    }

    public int GetgameId() {
        return this.gameId;
    }

    public String GetStatus() {
        return this.status;
    }

    public GameDomainObject Getgame() {
        //Lazy Load the game
        if (this.game == null) {
            this.game = GameModel.GetgameById(gameId);
        }
        return this.game;
    }

    public GameTypeDomainObject GetItemType() {
        //Lazy Load the ItemType
        if (this.itemType == null) {
            this.itemType = GameTypeModel.GetItemTypeById(itemTypeId);
        }
        return this.itemType;
    }


    public void SetStatus(String status) {
        this.status = status;
        BoardModel.Save(this);
    }
 
}
