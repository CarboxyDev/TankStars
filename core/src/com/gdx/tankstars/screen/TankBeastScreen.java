package com.gdx.tankstars.screen;

import com.gdx.tankstars.TankStarsGame;

public class TankBeastScreen extends TankScreen {
    private TankStarsGame game;

    public TankBeastScreen(TankStarsGame game) {
        super(game, "tank-3-screen.png");
        this.game = game;
    }
}
