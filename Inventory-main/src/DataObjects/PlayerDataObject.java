package DataObjects;

import DomainObjects.GameDomainObject;

public class PlayerDataObject {
    
    public int id;
    public String name;
    public String username;

    public int gameId = -1; 

    public PlayerDataObject (int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Copy Constructor
    public PlayerDataObject(PlayerDataObject player) {
        this.id = player.id;
        this.name = player.name;
        this.gameId = player.gameId;
    }    

    public PlayerDataObject (GameDomainObject player) {
        this.id = player.GetId();
        this.name = player.GetName();
        this.gameId = player.GetgameId();
    }




}
