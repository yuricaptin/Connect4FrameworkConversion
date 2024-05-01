package DataObjects;

import DomainObjects.GameDomainObject;
import DomainObjects.PlayerDomainObject;

public class PlayerDataObject {
    
    public int id;
    public String username;
    public String password;

    public int gameId = -1;

    //For ranking
    public int totalGames;
    public int gamesWon;
    public int gamesLost;
    public int placement;

    public PlayerDataObject (int id, String name, int totalGames, int gamesWon, int gamesLost, int placement) {
        this.id = id;
        this.username = name;
        this.totalGames = totalGames;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.placement = placement;
    }

    //Copy Constructor
    public PlayerDataObject(PlayerDataObject player) {
        this.id = player.id;
        this.username = player.username;
        this.gameId = player.gameId;
        this.totalGames = player.totalGames;
        this.gamesWon = player.gamesWon;
        this.gamesLost = player.gamesLost;
        this.placement = player.placement;
    }    

    public PlayerDataObject (PlayerDomainObject player) {
        this.id = player.GetId();
        this.username = player.GetUsername();
        this.gameId = player.GetgameId();
        this.totalGames = player.GetTotalGames();
        this.gamesWon = player.GetGamesWon();
        this.gamesLost = player.GetGamesLost();
        this.placement = player.GetPlacement();
    }




}
