package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.gdx.tankstars.TankStarsGame;

public class GameMatchScreen implements Screen {
    private TankStarsGame game;
    private Texture gameMatchScreenTexture;

    public GameMatchScreen(TankStarsGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        gameMatchScreenTexture = new Texture(Gdx.files.internal("bg-game.png"));
    }

    @Override
    public void render(float delta) {
        game.getBatch().begin();
        game.getBatch().draw(gameMatchScreenTexture, 0, 0);
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
        gameMatchScreenTexture.dispose();
    }

}
