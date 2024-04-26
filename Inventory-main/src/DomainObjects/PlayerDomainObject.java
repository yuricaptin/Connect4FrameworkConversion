package DomainObjects;

import java.util.ArrayList;

import DataObjects.GameDataObject;
import DataObjects.PlayerDataObject;
import Models.GameModel;
import Models.PlayerModel;

public class PlayerDomainObject {
    
    private int id;
    private String name;
    private int gameId;

    private GameDomainObject game; 

    public PlayerDomainObject (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PlayerDomainObject (PlayerDataObject player) {
        this.id = player.id;
        this.name = player.name;
        this.gameId = player.gameId;
    }

    public static ArrayList<PlayerDomainObject> MapList(ArrayList<PlayerDataObject> playerdata) {
        ArrayList<PlayerDomainObject> playerDomain = new ArrayList<PlayerDomainObject>();
        for(PlayerDataObject player : playerdata) {
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
        PlayerModel.Save(this);
    }


}