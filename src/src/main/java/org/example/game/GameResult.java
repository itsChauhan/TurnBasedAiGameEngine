package org.example.game;

public class GameResult {
    boolean isOver;
    String player;

    public GameResult(boolean isOver, String player) {
        this.isOver = isOver;
        this.player = player;
    }

    public boolean isOver() {
        return isOver;
    }

    public String getPlayer() {
        return player;
    }


    @Override
    public String toString(){
        if(!isOver()){
            return "Game is still going on....";
        }
        return  "Winner : " + player;

    }

}
