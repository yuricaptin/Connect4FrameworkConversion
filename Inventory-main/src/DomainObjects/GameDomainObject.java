package DomainObjects;

import java.util.ArrayList;

import DataObjects.GameDataObject;
import Models.BoardModel;
import Models.GameModel;
import Models.playerModel;

public class GameDomainObject {
    
    private int id; 
    private String name; 
    private int playerId;             // <---- How is this being set?

    private GameDomainObject player;

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

    public int GetplayerId() {
        return this.playerId;
    }


    public GameDomainObject Getplayer() {
        //Lazy Load the player
        if (this.player == null) {
            this.player = playerModel.GetplayerById(playerId);
        }
        return this.player;
    }

    public void Setplayer(int playerId) {
        this.playerId = playerId;
        GameModel.Save(this);
    }

}
