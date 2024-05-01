package DataAccess;

import java.util.ArrayList;

import DataObjects.BoardDataObject;
import DataObjects.PlayerDataObject;

public class PlayerDataAccess {

    public static ArrayList<PlayerDataObject> players = new ArrayList<PlayerDataObject>();
    private static int nextId = 0;    

    public PlayerDataAccess() {
        initialize();
    }

    private void initialize() {
        players.add(new PlayerDataObject(0, "username1"));
        players.add(new PlayerDataObject(1, "two"));
        players.add(new PlayerDataObject(2, "three"));
        nextId = 3;
    }

    private static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }

    public static ArrayList<PlayerDataObject> GetAllplayers() {
        ArrayList<PlayerDataObject> playersList = new ArrayList<PlayerDataObject>();
        //Create a copy of players to return.
        for (PlayerDataObject player: players) {
            playersList.add(new PlayerDataObject(player));
        }
        return playersList;
    }

    public static PlayerDataObject GetplayerById(int id) {
        for( PlayerDataObject player : players) {
            if (player.id == id) {
                return new PlayerDataObject(player);
            }
        }
        return null;
    }

    public static PlayerDataObject GetAvailableplayer() {
        for( PlayerDataObject player : players) {
            if (player.gameId == -1) {
                return new PlayerDataObject(player);
            }
        }
        return null;
    }


    public static PlayerDataObject Addplayer(PlayerDataObject newplayer) {
        newplayer.id = getNextId(); 
        players.add(newplayer);
        return newplayer;
    }


    public static void Save(PlayerDataObject playerToSave) {
        for( PlayerDataObject player : players) {
            if (player.id == playerToSave.id) {
                player.username = playerToSave.username;
                player.gameId = playerToSave.gameId;
            }
        }
    }


}
