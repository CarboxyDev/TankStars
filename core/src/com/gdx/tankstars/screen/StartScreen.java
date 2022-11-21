package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.gdx.tankstars.TankStarsGame;

public class StartScreen implements Screen {

    final TankStarsGame game;
    Texture startScreenTexture;
    float timeCounter;

    public StartScreen(final TankStarsGame myGame) {
        this.game = myGame;
    }


    @Override
    public void show() {
        startScreenTexture = new Texture(Gdx.files.internal("start-screen.png"));
    }

    @Override
    public void render(float delta) {
        timeCounter += delta;

        game.batch.begin();
        game.batch.draw(startScreenTexture, 0, 0);
        game.batch.end();

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
