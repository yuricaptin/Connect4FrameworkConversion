package DomainObjects;

import java.util.ArrayList;

import DataObjects.BoardDataObject;
import Models.BoardModel;
import Models.GameTypeModel;
import Models.GameModel;

public class BoardDomainObject {

    public int[][] board = new int[6][7]; // empty board    
    private int id; 
    private int gameTypeId;
    private int gameId; 
    private String status;

    private GameTypeDomainObject gameType; 
    private GameDomainObject game;

    public BoardDomainObject (int[][] board, int id, int itemTypeId, int gameId, String status) {
        this.board = board;
        this.id = id;
        this.gameTypeId = itemTypeId;
        this.gameId = gameId;
        this.status = status;
    }

    public BoardDomainObject (BoardDataObject board) {
        this.board = board.board;
        this.id = board.id;
        this.gameTypeId = board.itemTypeId;
        this.gameId = board.gameId;
        this.status = board.status;
    }

    public static ArrayList<BoardDomainObject> MapList(ArrayList<BoardDataObject> itemdata) {
        ArrayList<BoardDomainObject> itemDomain = new ArrayList<BoardDomainObject>();
        for(BoardDataObject item : itemdata) {
            itemDomain.add(new BoardDomainObject(item));
        }
        return itemDomain;
    }

    public int[][] GetBoard() {
        return this.board;
    }

    public int GetId() {
        return this.id;
    }

    public int GetItemTypeId() {
        return this.gameTypeId;
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
            this.game = GameModel.GetGameById(gameId);
        }
        return this.game;
    }

    public GameTypeDomainObject GetItemType() {
        //Lazy Load the ItemType
        if (this.gameType == null) {
            this.gameType = GameTypeModel.GetGameTypeById(gameTypeId);
        }
        return this.gameType;
    }

    // public void SetBoard(int[][] board) {
    //     this.board = board;
    // }

    public void SetStatus(String status) {
        this.status = status;
        BoardModel.Save(this);
    }
 
}
