package DomainObjects;

import java.util.ArrayList;

import DataObjects.GameDataObject;
import Models.BoardModel;
import Models.GameModel;
import Models.PlayerModel;

public class GameDomainObject {
    
    private int id; 
    private String name; 
    private int player1Id;             // <---- How is this being set?
    private int player2Id; 

    private PlayerDomainObject player;

    public GameDomainObject (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public GameDomainObject (GameDataObject game) {
        this.id = game.id;
        this.name = game.name;
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

    public String GetName() {
        return this.name;
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
