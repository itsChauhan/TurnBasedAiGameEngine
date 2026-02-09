package org.example.api;

import org.example.boards.TicToeBoard;
import org.example.game.Board;
import org.example.game.Cell;
import org.example.game.Move;
import org.example.game.Player;

public class AiEngine {
    public Move suggestMove(Player computer, Board board) {
        if (board instanceof TicToeBoard ticToeBoard) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (ticToeBoard.getCell(i, j) == null) {
                        return new Move(new Cell(i, j),computer);
                    }
                }
            }
            throw new IllegalStateException("this should not be the case ever...");
        } else {
            throw new IllegalArgumentException("Board Not configured in system yet!!!!");
        }
    }
}

