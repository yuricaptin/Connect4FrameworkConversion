package DomainObjects;

import java.util.ArrayList;

import DataObjects.BoardDataObject;
import Models.BoardModel;
import Models.GameTypeModel;
import Models.GameModel;

public class BoardDomainObject {
    public enum Status {
            FREE, TAKEN;

            public static Status fromString(String statusStr){
                if (statusStr != null){
                    for (Status status : Status.values()){
                        if (statusStr.equalsIgnoreCase(status.name())){
                            return status;
                        }
                    }
            }
    }

}


    public String[][] board = new String[6][7]; // empty board    
    private int id; 
    private int gameTypeId;
    private int gameId; 
    private Status status;

    private GameTypeDomainObject gameType; 
    private GameDomainObject game;

    

    public BoardDomainObject (String[][] board, int id, int gameTypeId, int gameId, Status status) {
        this.board = board;
        this.id = id;
        this.gameTypeId = gameTypeId;
        this.gameId = gameId;
        this.status = status;
    }

    public BoardDomainObject (BoardDataObject board) {
        this.board = board.board;
        this.id = board.id;
        this.gameTypeId = board.gameTypeId;
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

    public String[][] GetBoard() {
        return this.board;
    }

    public int GetId() {
        return this.id;
    }

    public int GetGameTypeId() {
        return this.gameTypeId;
    }

    public int GetgameId() {
        return this.gameId;
    }

    public Status GetStatus() {
        return this.status;
    }

    public GameDomainObject Getgame() {
        //Lazy Load the game
        if (this.game == null) {
            this.game = GameModel.GetgameById(gameId);
        }
        return this.game;
    }

    public GameTypeDomainObject GetGameType() {
        //Lazy Load the ItemType
        if (this.gameType == null) {
            this.gameType = GameTypeModel.GetGameTypeById(gameTypeId);
        }
        return this.gameType;
    }


    public void SetStatus(String status) {
        this.status = status;
        BoardModel.Save(this);
    }
 
}
