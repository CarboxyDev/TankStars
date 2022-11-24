package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.gdx.tankstars.TankStarsGame;

public class GamePauseScreen implements Screen {
    private TankStarsGame game;
    private Texture pauseScreenTexture;

    public GamePauseScreen(TankStarsGame game) {
        this.game = game;
    }


    @Override
    public void show() {
        pauseScreenTexture = new Texture(Gdx.files.internal("pause-screen.png"));
    }

    @Override
    public void render(float delta) {
        game.getBatch().begin();
        game.getBatch().draw(pauseScreenTexture, 0, 0);
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
        pauseScreenTexture.dispose();
    }
}
