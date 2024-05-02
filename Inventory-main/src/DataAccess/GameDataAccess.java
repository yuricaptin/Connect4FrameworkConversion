package DataAccess;

import java.util.ArrayList;
import DataObjects.GameDataObject;

public class GameDataAccess {

    private static ArrayList<GameDataObject> games = new ArrayList<GameDataObject>();
    private static int nextId = 0;  

    public GameDataAccess() {
        initialize();
    }

    private void initialize() {
        games.add(new GameDataObject(0, 1));
        games.add(new GameDataObject(1, 1));
        games.add(new GameDataObject(2, 1));
        nextId = 3;

    }

    private static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }

    public static ArrayList<GameDataObject> GetAllgames() {
        ArrayList<GameDataObject> gamesList = new ArrayList<GameDataObject>();
        //Create a copy of games to return.
        for (GameDataObject game: games) {
            gamesList.add(new GameDataObject(game));
        }
        return gamesList;
    }

    public static GameDataObject GetgameById(int id) {
        for( GameDataObject game : games) {
            if (game.id == id) {
                return new GameDataObject(game);
            }
        }
        return null;
    }

    public static GameDataObject Addgame(GameDataObject newgame) {
        newgame.id = getNextId(); 
        games.add(newgame);
        return newgame;
    }

    public static void Save(GameDataObject gameToSave) {
        for( GameDataObject game : games) {
            if (game.id == gameToSave.id) {
                game.gameTypeId = gameToSave.gameTypeId;
                game.player1Id = gameToSave.player1Id;
                game.player2Id = gameToSave.player2Id;
            }
        }
    }

}
