package com.gdx.tankstars.screen;

import com.gdx.tankstars.TankStarsGame;

public class TankBlazeScreen extends TankScreen {
    private TankStarsGame game;

    public TankBlazeScreen(TankStarsGame game) {
        super(game, "tank-1-screen.png");
        this.game = game;
    }

}
