package com.gdx.tankstars.screen;

import com.gdx.tankstars.TankStarsGame;

public class BlazeTankScreen extends TankScreen {
    private TankStarsGame game;

    public BlazeTankScreen(TankStarsGame game) {
        super(game, "tank-1-screen.png");
        this.game = game;
    }

}
