package DataObjects;

import DomainObjects.BoardDomainObject;

public class BoardDataObject {
    public final static String STATUS_AVAILABLE = "Available";
    public final static String STATUS_ORDERED = "Ordered";

    public int[][] board = new int[6][7]; // empty board
    public int id; 
    public int itemTypeId; 
    public int gameId;
    public String status; 


    public BoardDataObject (int[][] board, int id, int itemTypeId, int gameId, String status) {
        this.board = board;
        this.id = id;
        this.itemTypeId = itemTypeId;
        this.gameId = gameId;
        this.status = status;
    }

    //Copy Constructor
    public BoardDataObject(BoardDataObject board) {
        this.board = board.board;
        this.id = board.id;
        this.itemTypeId = board.itemTypeId;
        this.gameId = board.gameId;
        this.status = board.status;
    }  

    public BoardDataObject (BoardDomainObject board) {
        this.board = board.GetBoard();
        this.id = board.GetId();
        this.itemTypeId = board.GetItemTypeId();
        this.gameId = board.GetgameId();
        this.status = board.GetStatus();
    }
}
