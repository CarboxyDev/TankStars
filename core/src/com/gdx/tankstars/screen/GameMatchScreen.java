package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.gdx.tankstars.TankStarsGame;
import com.gdx.tankstars.game.GameMatch;
import com.gdx.tankstars.game.TerrainGenerator;

public class GameMatchScreen implements Screen {

    private TankStarsGame game;
    private Texture backgroundTexture;
    GameMatch gameMatch;

    public GameMatchScreen(TankStarsGame game) {
        this.game = game;
        System.out.println("Player 1 -> Tank " + game.getPlayer1());
        System.out.println("Player 2 -> Tank " + game.getPlayer2());
    }


    @Override
    public void show() {
        backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        gameMatch = new GameMatch(game);
        gameMatch.start();
    }

    @Override
    public void render(float delta) {
        game.getBatch().begin();
        game.getBatch().draw(backgroundTexture, 0, 0);
        //gameMatch.drawAssets();
        game.getBatch().end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
