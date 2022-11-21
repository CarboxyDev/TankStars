package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.gdx.tankstars.TankStarsGame;

public class StartScreen implements Screen {

    private TankStarsGame game;
    private Texture startScreenTexture;
    private float timeCounter;

    public StartScreen(TankStarsGame game) {
        this.game = game;
    }


    @Override
    public void show() {
        startScreenTexture = new Texture(Gdx.files.internal("start-screen.png"));
    }

    @Override
    public void render(float delta) {
        timeCounter += delta;

        game.getBatch().begin();
        game.getBatch().draw(startScreenTexture, 0, 0);
        game.getBatch().end();

        if (timeCounter > 5) {
            game.setScreen(new MenuScreen(game));
            this.dispose();
        }
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
        startScreenTexture.dispose();
    }
}
