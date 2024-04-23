package DataAccess;

import java.util.ArrayList;

import DataObjects.BoardDataObject;
import DataObjects.GameDataObject;

public class PlayerDataAccess {

    public static ArrayList<GameDataObject> players = new ArrayList<GameDataObject>();
    private static int nextId = 0;    

    public PlayerDataAccess() {
        initialize();
    }

    private void initialize() {
        players.add(new GameDataObject(0, "zero"));
        players.add(new GameDataObject(1, "one"));
        nextId = 2;
    }

    private static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }

    public static ArrayList<GameDataObject> GetAllplayers() {
        ArrayList<GameDataObject> playersList = new ArrayList<GameDataObject>();
        //Create a copy of players to return.
        for (GameDataObject player: players) {
            playersList.add(new GameDataObject(player));
        }
        return playersList;
    }

    public static GameDataObject GetplayerById(int id) {
        for( GameDataObject player : players) {
            if (player.id == id) {
                return new GameDataObject(player);
            }
        }
        return null;
    }

    public static GameDataObject GetAvailableplayer() {
        for( GameDataObject player : players) {
            if (player.gameId == -1) {
                return new GameDataObject(player);
            }
        }
        return null;
    }


    public static GameDataObject Addplayer(GameDataObject newplayer) {
        newplayer.id = getNextId(); 
        players.add(newplayer);
        return newplayer;
    }


    public static void Save(GameDataObject playerToSave) {
        for( GameDataObject player : players) {
            if (player.id == playerToSave.id) {
                player.name = playerToSave.name;
                player.gameId = playerToSave.gameId;
            }
        }
    }


}
