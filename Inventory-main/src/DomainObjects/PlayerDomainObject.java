package DomainObjects;

import java.util.ArrayList;

import DataObjects.GameDataObject;
import DataObjects.PlayerDataObject;
import Models.GameModel;
import Models.PlayerModel;

public class PlayerDomainObject {
    
    private int id;
    private String username;
    private String password;
    private int gameId;

    private GameDomainObject game; 

    public PlayerDomainObject (int id, String username) {
        this.id = id;
        this.username = username;
    }

    public PlayerDomainObject (PlayerDataObject player) {
        this.id = player.id;
        this.username = player.username;
        this.password = player.password;
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

    public String GetUsername() {
        return this.username;
    }

    public String GetPassword() {
        return this.password;
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