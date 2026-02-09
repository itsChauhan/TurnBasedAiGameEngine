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

    public void move(Board board, Move move) {
        if(board instanceof TicToeBoard ){
            board.move(move);
            return;
        }
        throw new IllegalArgumentException("Invalid board type !!!");
    }
}


