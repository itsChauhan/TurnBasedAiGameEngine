package org.example.api;

import org.example.boards.TicToeBoard;
import org.example.game.Board;
import org.example.game.GameResult;

public class GameRuleEngine {

    public GameResult isComplete(Board board) {
        boolean rowComplete = true;
        boolean colComplete = true;
        boolean diaComplete = true;
        boolean revDiaComplete = true;
        String firstCharacter = "-";
        if (board instanceof TicToeBoard ticToeBoard) {
            for (int i = 0; i < 3; i++) {
                firstCharacter = ticToeBoard.getCell(i, 0);
                rowComplete = firstCharacter !=null;
                if(firstCharacter!=null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstCharacter.equals(ticToeBoard.getCell(i, j))) {
                            rowComplete = false;
                            break;
                        }
                    }
                }

                if (rowComplete)
                    return new GameResult(true, firstCharacter);
                ;
            }


            for (int i = 0; i < 3; i++) {
                firstCharacter = ticToeBoard.getCell(0, i);
                colComplete = firstCharacter != null;
                if(firstCharacter!=null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstCharacter.equals(ticToeBoard.getCell(j, i))) {
                            colComplete = false;
                            break;
                        }
                    }
                }
                if (colComplete)
                    return new GameResult(true, firstCharacter);
                ;
            }

            for (int i = 0; i < 3; i++) {
                firstCharacter = ticToeBoard.getCell(0, 0);
                diaComplete = firstCharacter !=null;
                if(firstCharacter == null){
                    break;
                }
                if (!firstCharacter.equals(ticToeBoard.getCell(i, i))) {
                    diaComplete = false;
                    break;
                }
            }

            if (diaComplete) {
                return new GameResult(true, firstCharacter);
            }

            for (int i = 0; i < 3; i++) {
                firstCharacter = ticToeBoard.getCell(0, 2);
                revDiaComplete = firstCharacter!=null;
                if(firstCharacter == null){
                    break;
                }
                if (!firstCharacter.equals(ticToeBoard.getCell(i, 2-i))) {
                    revDiaComplete = false;
                    break;
                }
            }
            if (revDiaComplete) {
                return new GameResult(true, firstCharacter);
            }


            int countOfFilledCells = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(ticToeBoard.getCell(i,j)!=null)
                        countOfFilledCells++;
                }
            }
            return countOfFilledCells == 9 ? new GameResult(true, "") : new GameResult(false, "");

        } else {
            return new GameResult(false, "");
        }

    }
}
