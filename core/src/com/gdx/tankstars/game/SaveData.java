package com.gdx.tankstars.game;

import com.gdx.tankstars.TankStarsGame;

public class SaveData {
    private State state;
    private TankStarsGame game;

    public SaveData(TankStarsGame game, State state) {
        this.game = game;
        this.state = state;
    }
}
