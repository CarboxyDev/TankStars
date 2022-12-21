package com.gdx.tankstars.game;


import com.gdx.tankstars.TankStarsGame;

// make this a singleton
// This basically stores the state of the game
public class State {
    private TankStarsGame game;
    private int turn; // 1 for player 1, 2 for player 2
    private Player1 player1;
    private Player2 player2;

    public State(TankStarsGame game) {
        this.game = game;
        this.turn = 1;
    }

    public int getTurn() {
        return this.turn;
    }

    public void changeTurn() {
        if (turn == 1) {
            turn = 2;
        }
        else if (turn == 2){
            turn = 1;
        }
    }



}
