package org.example.api;

import org.example.game.*;
import org.example.boards.TicToeBoard;

import javax.swing.*;

public class TurnBasedAiGameEngine {

    public Board startGame(String type) {
        if (type.equals("TicTacToe")) {
            return new TicToeBoard();
        } else {
            throw new IllegalArgumentException("Invalid Board Type!!!");
        }
    }

    public void move(Board board, Player player, Move move) {
        if (board instanceof TicToeBoard ticToeBoard) {
            ticToeBoard.setCell(move.getCell(), player.getSymbol());
        } else {
            throw new IllegalArgumentException("Board does not exist!!!");
        }

    }

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


    public Move suggestMove(Player computer, Board board) {
        if (board instanceof TicToeBoard ticToeBoard) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (ticToeBoard.getCell(i, j) == null) {
                        return new Move(new Cell(i, j));
                    }
                }
            }
            throw new IllegalStateException("this should not be the case ever...");
        } else {
            throw new IllegalArgumentException("Board Not configured in system yet!!!!");
        }
    }
}


