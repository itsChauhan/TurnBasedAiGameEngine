package org.example;

import org.example.api.AiEngine;
import org.example.api.GameRuleEngine;
import org.example.api.TurnBasedAiGameEngine;
import org.example.boards.TicToeBoard;
import org.example.game.Board;
import org.example.game.Cell;
import org.example.game.Move;
import org.example.game.Player;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static  AiEngine aiEngine = new AiEngine();
    private static GameRuleEngine gameRuleEngine = new GameRuleEngine();



    public static void main(String[] args) {
        System.out.println("Running first java code on my laptop");
        TurnBasedAiGameEngine gameEngine = new TurnBasedAiGameEngine();
        Board board = gameEngine.startGame("TicTacToe");
        Player opponent = new Player("O");
        Player computer = new Player("X");
        Scanner scanner = new Scanner(System.in);
        while(!gameRuleEngine.isComplete(board).isOver()){
            System.out.println(board);
            System.out.println("Make Your Move");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            Move oppMove = new Move(new Cell(row, col), opponent);
            gameEngine.move(board, oppMove);
            System.out.println(board);
            if(!gameRuleEngine.isComplete(board).isOver()){
                Move computerMove = aiEngine.suggestMove(computer, board);
                gameEngine.move(board, computerMove);
            }
        }

        System.out.println("GameResult : " + gameRuleEngine.isComplete(board));
        System.out.println(board);







    }






}