package com.gdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.tankstars.TankStarsGame;

public class GameMatch extends State {
    private TankStarsGame game;

    public Tank getTank() {
        return tank;
    }

    private Tank tank;


    public GameMatch(TankStarsGame game) {
        super(game);
        this.game = game;
        this.tank = new Tank1();
    }

    public void start() {
        System.out.println("Game has been started.");
        //TerrainGenerator terrainGenerator = new TerrainGenerator(game);
        //game.setScreen(terrainGenerator);

        //this.tank = new Tank(new Texture(Gdx.files.internal("tanks/frostbite.png")));
        this.drawAssets();
    };

    public void drawAssets() {

//        game.getBatch().draw(tank, tank.getX(), tank.getY(), tank.getOriginX(), tank.getOriginY(), tank.getWidth(), tank.getHeight(), tank.getScaleX(), tank.getScaleY(), tank.getRotation());
        tank.draw(game.getBatch());

    }

}
