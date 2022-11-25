package com.gdx.tankstars.screen;

import com.gdx.tankstars.TankStarsGame;

public class FrostbiteTankScreen extends TankScreen {
    private TankStarsGame game;

    public FrostbiteTankScreen(TankStarsGame game) {
        super(game, "tank-2-screen.png");
        this.game = game;
    }
}
