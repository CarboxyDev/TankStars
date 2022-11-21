package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gdx.tankstars.TankStarsGame;

public class TankScreen implements Screen  {

    TankStarsGame game;
    private ShapeRenderer shapeRenderer;
    private Texture tankScreen;
    private String screenPath;

    public TankScreen(TankStarsGame game, String screenPath) {
        this.game = game;
        this.screenPath = screenPath;
    }

    public void setScreenPath(String path) {
        this.screenPath = path;
    }

    public String getScreenPath() {
        return this.screenPath;
    }




    @Override
    public void show() {
        tankScreen = new Texture(Gdx.files.internal(screenPath));
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(tankScreen, 0, 0);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
}
