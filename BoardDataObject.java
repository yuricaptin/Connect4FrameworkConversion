package DataObjects;

import DomainObjects.BoardDomainObject;
import DomainObjects.BoardDomainObject.Status;

public class BoardDataObject {
    
    public String[][] board = new String[6][7]; // empty board
    public int id; 
    public int gameTypeId; 
    public int gameId;
    public Status status; 


    public BoardDataObject (String[][] board, int id, int gameTypeId, int gameId, String statusStr) {
        this.board = board;
        this.id = id;
        this.gameTypeId = gameTypeId;
        this.gameId = gameId;
        this.status = Status.fromString(statusStr);
    }

    //Copy Constructor
    public BoardDataObject(BoardDataObject board) {
        this.board = board.board;
        this.id = board.id;
        this.gameTypeId = board.gameTypeId;
        this.gameId = board.gameId;
        this.status = board.status;
    }  

    public BoardDataObject (BoardDomainObject board) {
        this.board = board.GetBoard();
        this.id = board.GetId();
        this.gameTypeId = board.GetGameTypeId();
        this.gameId = board.GetgameId();
        this.status = Status.valueOf(board.GetStatus());
    }
}
