package Models;

import java.util.ArrayList;

import DataAccess.BoardDataAccess;
import DataObjects.BoardDataObject;
import DomainObjects.BoardDomainObject;

public class BoardModel {

    public static BoardDomainObject GetBoardById(int id) {
        BoardDataObject boardData = BoardDataAccess.GetBoardById(id);
        return new BoardDomainObject(boardData);
    }

    public static BoardDomainObject GetFirstAvailableByBoardTypeId(int boardTypeId) {
        BoardDataObject boardData = BoardDataAccess.GetFirstAvailableByBoardTypeId(boardTypeId);
        
        if (boardData == null) {
            return null;
        }

        return new BoardDomainObject(boardData);
    }

    public static ArrayList<BoardDomainObject> GetAllItems() {
        ArrayList<BoardDataObject> boardDataList = BoardDataAccess.GetAllBoards();
        return BoardDomainObject.MapList(boardDataList);
    }

    public static ArrayList<BoardDomainObject> GetBoardsByBoardTypeId(int id) {
        ArrayList<BoardDataObject> boardDataList = BoardDataAccess.GetBoardsByBoardTypeId(id );
        return BoardDomainObject.MapList(boardDataList);
    }

    public static BoardDomainObject AddItem(BoardDomainObject board){

        validateItem(board);

        BoardDataObject boardData = new BoardDataObject(board);
        BoardDataAccess.AddBoard(boardData);
        return new BoardDomainObject(boardData);
  
    }
    

    private static void validateItem(BoardDomainObject board) {

    }


    public static void Save (BoardDomainObject boardToSave) {
        BoardDataObject BoardDataObject = new BoardDataObject(boardToSave);
        BoardDataAccess.Save(BoardDataObject);
    }
  


}
