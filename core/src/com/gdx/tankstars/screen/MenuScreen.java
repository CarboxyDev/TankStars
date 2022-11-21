package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.gdx.tankstars.TankStarsGame;

public class MenuScreen implements Screen {

    TankStarsGame game;
    Texture startScreen;


    public MenuScreen(TankStarsGame myGame) {
        game = myGame;
    }


    @Override
    public void show() {
        startScreen = new Texture(Gdx.files.internal("menu-screen.png"));
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(startScreen, 0, 0);
        game.batch.end();

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
