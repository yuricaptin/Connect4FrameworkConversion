package DomainObjects;

import java.util.ArrayList;

import DataObjects.GameDataObject;
import Models.BoardModel;
import Models.GameModel;
import Models.PlayerModel;

public class GameDomainObject {
    
    private int id; 
    private int boardId;
    private int gameTypeId; 
    private int player1Id;             // <---- How is this being set?
    private int player2Id; 

    private PlayerDomainObject player;

    public GameDomainObject (int id, int boardId, int gameTypeId) {
        this.boardId = boardId;
        this.id = id;
        this.gameTypeId = gameTypeId;
    }

    public GameDomainObject (GameDataObject game) {
        this.boardId = game.boardId;
        this.id = game.id;
        this.gameTypeId = game.gameTypeId;
    }

    public static ArrayList<GameDomainObject> MapList(ArrayList<GameDataObject> gamedata) {
        ArrayList<GameDomainObject> gameDomain = new ArrayList<GameDomainObject>();
        for(GameDataObject game : gamedata) {
            gameDomain.add(new GameDomainObject(game));
        }
        return gameDomain;
    }

    public int GetId() {
        return this.id;
    }

    public int GetBoardId() {
        return this.boardId;
    }

    public int GetGameTypeId() {
        return this.gameTypeId;
    }

    public int Getplayer1Id() {
        return this.player1Id;
    }

    public int Getplayer2Id() {
        return this.player2Id;
    }

    public PlayerDomainObject Getplayer1() {
        //Lazy Load the player
        if (this.player == null) {
            this.player = PlayerModel.GetplayerById(player1Id);
        }
        return this.player;
    }

    public PlayerDomainObject Getplayer2() {
        //Lazy Load the player
        if (this.player == null) {
            this.player = PlayerModel.GetplayerById(player2Id);
        }
        return this.player;
    }

    public void Setplayer1(int player1Id) {
        this.player1Id = player1Id;
        GameModel.Save(this);
    }

    public void Setplayer2(int player2Id) {
        this.player2Id = player2Id;
        GameModel.Save(this);
    }

}
