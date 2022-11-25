package com.gdx.tankstars.screen;

import com.gdx.tankstars.TankStarsGame;

public class BeastTankScreen extends TankScreen {
    private TankStarsGame game;

    public BeastTankScreen(TankStarsGame game) {
        super(game, "tank-3-screen.png");
        this.game = game;
    }
}
