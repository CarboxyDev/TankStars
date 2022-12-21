package com.gdx.tankstars.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.tankstars.TankStarsGame;

public class GameMatch {
    private TankStarsGame game;
    private Tank tank;


    public GameMatch(TankStarsGame game) {
        this.game = game;
    }

    public void start() {
        System.out.println("Game has been started.");
        TerrainGenerator terrainGenerator = new TerrainGenerator(game);
        game.setScreen(terrainGenerator);

        //this.tank = new Tank(new Texture(Gdx.files.internal("tanks/frostbite.png")));
        //this.drawAssets();
    };

    public void drawAssets() {
        SpriteBatch batch = new SpriteBatch();

        batch.begin();
        batch.draw(tank, tank.getX(), tank.getY(), tank.getOriginX(), tank.getOriginY(), tank.getWidth(), tank.getHeight(), tank.getScaleX(), tank.getScaleY(), tank.getRotation());
        batch.end();

    }

}
