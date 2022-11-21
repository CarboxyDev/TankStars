package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gdx.tankstars.TankStarsGame;

public class Tank1Screen implements Screen {

    TankStarsGame game;
    private ShapeRenderer shapeRenderer;
    private Texture tank1Screen;

    public Tank1Screen(TankStarsGame game) {
        this.game = game;
        tank1Screen = new Texture(Gdx.files.internal("tank-1-screen.png"));
    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(tank1Screen, 0, 0);
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
