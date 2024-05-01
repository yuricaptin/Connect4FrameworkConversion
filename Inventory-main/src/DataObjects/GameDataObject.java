package DataObjects;

import DomainObjects.GameDomainObject;

public class GameDataObject {
    
    public int id;
    public int boardId;
    public int gameTypeId;
    public int player1Id = -1;
    public int player2Id = -1;

    public GameDataObject (int id, int gameTypeId) {
        this.id = id;
        this.gameTypeId = id;
        //this.playerId = -1;  This is being handled in the initializer above.
    }

    //Copy Constructor
    public GameDataObject(GameDataObject game) {
        this.id = game.id;
        this.gameTypeId = game.gameTypeId;
        this.player1Id = game.player1Id;
        this.player2Id = game.player2Id;
    }   

    public GameDataObject (GameDomainObject game) {
        this.id = game.GetId();
        this.gameTypeId = game.GetGameTypeId();
        this.player1Id = game.Getplayer1Id();
        this.player2Id = game.Getplayer2Id();
    }
 
}
