package DataObjects;

import DomainObjects.PlayerDomainObject;

public class PlayerDataObject {
    
    public int id;
    public String username;
    public String password;

    public int gameId = -1; 

    public PlayerDataObject (int id, String name, String password) {
        this.id = id;
        this.username = name;
        this.password = password;
    }

    //Copy Constructor
    public PlayerDataObject(PlayerDataObject player) {
        this.id = player.id;
        this.username = player.username;
        this.gameId = player.gameId;
    }    

    public PlayerDataObject (PlayerDomainObject player) {
        this.id = player.GetId();
        this.username = player.GetUsername();
        this.gameId = player.GetgameId();
    }




}
