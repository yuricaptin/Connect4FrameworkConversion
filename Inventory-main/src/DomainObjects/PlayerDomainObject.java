package DomainObjects;

import java.util.ArrayList;

import DataObjects.GameDataObject;
import Models.GameModel;
import Models.playerModel;

public class PlayerDomainObject {
    
    private int id;
    private String name;
    private int gameId;

    private GameDomainObject game; 

    public PlayerDomainObject (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PlayerDomainObject (GameDataObject player) {
        this.id = player.id;
        this.name = player.name;
    }

    public static ArrayList<PlayerDomainObject> MapList(ArrayList<GameDataObject> playerdata) {
        ArrayList<PlayerDomainObject> playerDomain = new ArrayList<PlayerDomainObject>();
        for(GameDataObject player : playerdata) {
            playerDomain.add(new PlayerDomainObject(player));
        }
        return playerDomain;
    }

    public int GetId() {
        return this.id;
    }

    public String GetName() {
        return this.name;
    }

    public int GetgameId() {
        return this.gameId;
    }


    public GameDomainObject Getgame() {
        //Lazy Load the game
        if (this.game == null) {
            this.game = GameModel.GetgameById(gameId);
        }
        return this.game;
    }

    public void Setgame(int gameId) {
        this.gameId = gameId;
        playerModel.Save(this);
    }


}