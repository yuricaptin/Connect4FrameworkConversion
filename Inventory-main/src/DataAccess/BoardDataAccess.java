package DataAccess;

import java.util.ArrayList;
import DataObjects.BoardDataObject;

public class BoardDataAccess {

    private static ArrayList<BoardDataObject> items = new ArrayList<BoardDataObject>();
    private static int nextId = 0;  

    public BoardDataAccess() {
        initialize();
    }

    private void initialize() {        
        items.add(new BoardDataObject(
         new int[][]{ // Diagnol Win
             {1, -1, -1, -1, -1, -1, -1},
             {-1, 1, -1, -1, -1, -1, -1},
             {-1, -1, 1, -1, -1, -1, -1},
             {-1, -1, -1, 1, -1, -1, -1},
             {-1, -1, -1, -1, -1, -1, -1},
             {-1, -1, -1, -1, -1, -1, -1}
         } , 0, 1, 2, BoardDataObject.STATUS_AVAILABLE));

        // Test No Win
        // new int[][]{
        //     {-1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1}
        // }
        
        //Test Horizontal Win
        // new int[][]{
        //     {1, 1, 1, 1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1}
        // }

        // Test Vertical Win
        // new int[][]{
        //     {1, -1, -1, -1, -1, -1, -1},
        //     {1, -1, -1, -1, -1, -1, -1},
        //     {1, -1, -1, -1, -1, -1, -1},
        //     {1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1}
        // }

        //Test Diagonal Win
        // new int[][]{
        //     {1, -1, -1, -1, -1, -1, -1},
        //     {-1, 1, -1, -1, -1, -1, -1},
        //     {-1, -1, 1, -1, -1, -1, -1},
        //     {-1, -1, -1, 1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1},
        //     {-1, -1, -1, -1, -1, -1, -1}
        // }  

        items.add(new BoardDataObject(new int[6][7], 1, 1, 1, BoardDataObject.STATUS_AVAILABLE));
        items.add(new BoardDataObject(new int[6][7], 2, 1, 0, BoardDataObject.STATUS_AVAILABLE));
        nextId = 3;
    }
    
    private static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }

    public static ArrayList<BoardDataObject> GetAllBoards() {
        ArrayList<BoardDataObject> itemsList = new ArrayList<BoardDataObject>();
        //Create a copy of itemTypes to return.
        for (BoardDataObject item: items) {
            itemsList.add(new BoardDataObject(item));
        }
        return itemsList;
    }

    public static BoardDataObject GetBoardById(int id) {
        for( BoardDataObject item : items) {
            if (item.id == id) {
                return new BoardDataObject(item);
            }
        }
        return null;
    }

    public static BoardDataObject GetFirstAvailableByBoardTypeId(int itemTypeId) {
        for( BoardDataObject item : items) {
            if (item.itemTypeId == itemTypeId && item.status.equals(BoardDataObject.STATUS_AVAILABLE)) {
                return new BoardDataObject(item);
            }
        }
        return null;
    }


    public static ArrayList<BoardDataObject> GetBoardsByBoardTypeId(int itemTypeId) {
        ArrayList<BoardDataObject> itemsById = new ArrayList<BoardDataObject>();

        for( BoardDataObject item : items) {
            if (item.itemTypeId == itemTypeId) {
                itemsById.add(new BoardDataObject(item));
            }
        }
        return itemsById;
    }

    public static BoardDataObject AddBoard(BoardDataObject newBoard) {
        newBoard.id = getNextId(); 
        items.add(newBoard);
        return newBoard;
    }


    public static void Save(BoardDataObject itemToSave) {
        for( BoardDataObject item : items) {
            if (item.id == itemToSave.id) {
                item.itemTypeId = itemToSave.itemTypeId;
                item.gameId = itemToSave.gameId;
                item.status = itemToSave.status;
            }
        }
    }

}
