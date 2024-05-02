package Controller;

import DataObjects.BoardDataObject;
import DataObjects.GameDataObject;
import DomainObjects.BoardDomainObject;
import DomainObjects.GameDomainObject;
import Models.BoardModel;
import Models.GameModel;
import Models.GameTypeModel;
import Models.PlayerModel;
import restService.request.CheckForWinnerRequest;
import restService.request.CreateGameRequest;
import restService.response.CheckForWinnerResponse;
import restService.response.CreateGameResponse;

public class GameController {

    public static CreateGameResponse CreateGame (CreateGameRequest request) {
        try {
            int player1Id = request.GetPlayer1Id();
            int player2Id = request.GetPlayer2Id();
            int gameTypeId = request.GetGameTypeId();

            if(PlayerModel.GetplayerById(player1Id) == null){
                throw new Exception ("Player does not exist");
            }

            if(PlayerModel.GetplayerById(player2Id) == null){
                throw new Exception ("Player does not exist");
            }

            // Game Type ID Valid
            if(GameTypeModel.GetGameTypeById(gameTypeId) == null){
                throw new Exception ("Game Type does not exist");
            }

            GameDomainObject gameToCreate = GameModel.Addgame(new GameDomainObject(new GameDataObject(0, gameTypeId)));
            PlayerModel.GetplayerById(player1Id).Setgame(gameToCreate.GetId());
            PlayerModel.GetplayerById(player2Id).Setgame(gameToCreate.GetId());

            CreateGameResponse response = new CreateGameResponse(gameToCreate.GetId(), gameTypeId, player1Id, player2Id, player1Id, "Playing", -1, new BoardDataObject(new int[6][7], 0,0,0, ""));
            return response; 
        } catch (Exception ex) {
            CreateGameResponse response = new CreateGameResponse(ex.getMessage());
            return response; 
        }
    }

    public static CheckForWinnerResponse CheckForWinner (CheckForWinnerRequest request) {
        try {
            int gameId = request.GetGameId();
            int playerId = request.GetPlayerId();
            int column = request.GetColumn();
            int winner = -1;
            String status = "Playing";

            BoardDomainObject board = BoardModel.GetBoardById(GameModel.GetGameById(gameId).GetBoardId());

            // Too low
            if(column < 0){
                throw new Exception ("Column Invalid");
            }

            // Too high
            if(column > board.GetBoard()[0].length - 1){
                throw new Exception ("Column Invalid");
            }
            
            // to count consecutive tokens
            int streak = 0;

            // Horizontal Check
            for (int i = 0; i < board.GetBoard().length; i++) {
                streak = 0;
                for (int j = 0; j < board.GetBoard()[0].length; j++) {
                    if(board.GetBoard()[i][j] == playerId){ 
                        streak++;
                        if(streak >= 4){
                            // WINNER
                            winner = playerId;
                            status = "Completed";
                            CheckForWinnerResponse response = new CheckForWinnerResponse(gameId, status, winner);
                            return response; 
                        }
                    }
                    else streak = 0;
                }
            }

            // Vertical Check
            for (int i = 0; i < board.GetBoard()[0].length; i++) {
                streak = 0;
                for (int j = 0; j < board.GetBoard().length; j++) {
                    if(board.GetBoard()[j][i] == playerId){ 
                        streak++;
                        if(streak >= 4){
                            // WINNER
                            winner = playerId;
                            status = "Completed";
                            CheckForWinnerResponse response = new CheckForWinnerResponse(gameId, status, winner);
                            return response; 
                        }
                    }
                    else streak = 0;
                }
            }

            //Diagonal Check
            streak = 0;
            for (int i = 0; i < board.GetBoard().length; i++) {                
                for (int j = 0; j < board.GetBoard()[0].length; j++) {
                    // explore the board until a player token is found

                    // if it is found
                    if(board.GetBoard()[i][j] == playerId){                        
                        streak = 1;                        

                        // Up-Right
                        for(int x = i - 1, y = j + 1; 
                        x >= 0 && y < board.GetBoard()[0].length;
                        x--, y++) {
                            if(board.GetBoard()[x][y] == playerId){
                                streak++;
                                if(streak >= 4){
                                    // WINNER
                                    winner = playerId;
                                    status = "Completed";
                                    CheckForWinnerResponse response = new CheckForWinnerResponse(gameId, status, winner);
                                    return response; 
                                }
                            }
                            else break;
                        }

                        // Down-Left
                        for(int x = i + 1, y = j - 1; 
                        x < board.GetBoard().length && y >= 0;
                        x++, y--) {
                            if(board.GetBoard()[x][y] == playerId){
                                streak++;
                                if(streak >= 4){
                                    // WINNER
                                    winner = playerId;
                                    status = "Completed";
                                    CheckForWinnerResponse response = new CheckForWinnerResponse(gameId, status, winner);
                                    return response; 
                                }
                            }
                            else break;
                        }

                        streak = 1;

                        // Up-Left
                        for(int x = i - 1, y = j - 1; 
                        x >= 0 && y >= 0;
                        x--, y--) {
                            if(board.GetBoard()[x][y] == playerId){
                                streak++;
                                if(streak >= 4){
                                    // WINNER
                                    winner = playerId;
                                    status = "Completed";
                                    CheckForWinnerResponse response = new CheckForWinnerResponse(gameId, status, winner);
                                    return response; 
                                }
                            }
                            else break;
                        }

                        // Down-Right
                        for(int x = i + 1, y = j + 1; 
                        x < board.GetBoard().length && y < board.GetBoard()[0].length;
                        x++, y++) {
                            if(board.GetBoard()[x][y] == playerId){
                                streak++;
                                if(streak >= 4){
                                    // WINNER
                                    winner = playerId;
                                    status = "Completed";
                                    CheckForWinnerResponse response = new CheckForWinnerResponse(gameId, status, winner);
                                    return response; 
                                }
                            }
                            else break;
                        }
                    }
                    else streak = 0;
                }
            }

            // No Winner
            CheckForWinnerResponse response = new CheckForWinnerResponse(gameId, status, winner);
            return response; 
        } catch (Exception ex) {
            CheckForWinnerResponse response = new CheckForWinnerResponse(ex.getMessage());
            return response; 
        }        
    }
}