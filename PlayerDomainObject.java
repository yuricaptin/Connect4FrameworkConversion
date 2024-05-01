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

    private int totalGames;
    private int gamesWon;
    private int gamesLost;
    private int placement;

    private GameDomainObject game; 

    public PlayerDomainObject (int id, String username, String password, int gameId, int totalGames, int gamesWon, int gamesLost, int placement) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gameId = gameId;
        this.totalGames = totalGames;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.placement = placement;
    }

    public PlayerDomainObject (PlayerDataObject player) {
        this.id = player.id;
        this.username = player.username;
        this.password = player.password;
        this.gameId = player.gameId;
        this.totalGames = player.totalGames;
        this.gamesWon = player.gamesWon;
        this.gamesLost = player.gamesLost;
        this.placement = player.placement;
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

    public int GetTotalGames() {
        return this.totalGames;
    }

    public int GetGamesWon() {
        return this.gamesWon;
    }

    public int GetGamesLost() {
        return this.gamesLost;
    }

    public int GetPlacement() {
        return this.placement;
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
        this.totalGames++;
        PlayerModel.Save(this);
    }


}