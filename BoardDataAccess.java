package DataAccess;

import java.util.ArrayList;
import DataObjects.BoardDataObject;
import DomainObjects.BoardDomainObject;

public class BoardDataAccess {

    private static ArrayList<BoardDataObject> items = new ArrayList<BoardDataObject>();
    private static int nextId = 0;  

    public BoardDataAccess() {
        initialize();
    }

    private void initialize() {
        items.add(new BoardDataObject(new String[6][7], 0, 0, 0, BoardDataObject.STATUS_TAKEN));
        items.add(new BoardDataObject(new String[6][7], 1, 1, 1, BoardDataObject.STATUS_TAKEN));
        items.add(new BoardDataObject(new String[6][7], 2, 1, 0, BoardDataObject.STATUS_TAKEN));
        nextId = 3;
    }
    
    private static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }
    public static BoardDataObject getFirstAvailableBoard(){
        for (BoardDataObject board : items){
            if (board.getStatus() == BoardDataObject.Status.FREE){
                return board;
            }
        }
    }

    public static ArrayList<BoardDataObject> getAllAvailableBoards(){
        ArrayList<BoardDataObject> availableBoards = new ArrayList<>();
        for (BoardDataObject board : items){
            if (board.getStatus() == BoardDataObject.Status.FREE) {
                availableBoards.add(board);
            }
        }
        return availableBoards;
    }

    public static void setBoardStatus(int boardId, BoardDataObject.Status newStatus){
        for (BoardDataObject board : items){
            if (board.getId() == boardId){
                board.setStatus(newStatus);
                break;
            }
        }
    }

    public static ArrayList<BoardDataObject> GetAllItems() {
        ArrayList<BoardDataObject> itemsList = new ArrayList<BoardDataObject>();
        //Create a copy of itemTypes to return.
        for (BoardDataObject item: items) {
            itemsList.add(new BoardDataObject(item));
        }
        return itemsList;
    }

    public static BoardDataObject GetItemById(int id) {
        for( BoardDataObject item : items) {
            if (item.id == id) {
                return new BoardDataObject(item);
            }
        }
        return null;
    }

    public static BoardDataObject GetFirstAvailableByItemTypeId(int itemTypeId) {
        for( BoardDataObject item : items) {
            if (item.itemTypeId == itemTypeId && item.status.equals(BoardDataObject.STATUS_TAKEN)) {
                return new BoardDataObject(item);
            }
        }
        return null;
    }


    public static ArrayList<BoardDataObject> GetItemsByItemTypeId(int itemTypeId) {
        ArrayList<BoardDataObject> itemsById = new ArrayList<BoardDataObject>();

        for( BoardDataObject item : items) {
            if (item.itemTypeId == itemTypeId) {
                itemsById.add(new BoardDataObject(item));
            }
        }
        return itemsById;
    }

    public static BoardDataObject AddItem(BoardDataObject newItem) {
        newItem.id = getNextId(); 
        items.add(newItem);
        return newItem;
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
