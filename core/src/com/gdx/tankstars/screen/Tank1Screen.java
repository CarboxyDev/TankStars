package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gdx.tankstars.TankStarsGame;

public class Tank1Screen extends TankScreen {
    private TankStarsGame game;

    public Tank1Screen(TankStarsGame game) {
        super(game, "tank-1-screen.png");
        this.game = game;
    }

}
