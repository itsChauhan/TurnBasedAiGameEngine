package org.example.boards;

import org.example.game.Board;
import org.example.game.Cell;

public class TicToeBoard extends Board {
    String[][] cells = new String[3][3];


    public String getCell(int row, int col){
        return cells[row][col];
    }

    public void setCell(Cell cell, String symbol){
        cells[cell.getRow()][cell.getCol()] = symbol;
    }


    @Override
    public String toString(){
        String result = "";
        for(int i = 0;i<3;i++){
            for(int j = 0; j < 3; j++){
                if(cells[i][j] == null){

                }
                result+=cells[i][j]==null ? "-":cells[i][j];
            }
            result+="\n";
        }
        return result;
    }


}
