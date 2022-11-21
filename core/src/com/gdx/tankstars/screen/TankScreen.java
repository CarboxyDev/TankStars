package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gdx.tankstars.TankStarsGame;

public class TankScreen implements Screen  {

    private TankStarsGame game;
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
        if (Gdx.input.justTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            // handle event when tank button is clicked
            Rectangle rect1 = new Rectangle();
            rect1.x = 875;
            rect1.y = 42;
            rect1.width = 333;
            rect1.height = 87;
            if ((x > rect1.x && x < (rect1.x + rect1.width)) && (y > rect1.y && y < (rect1.y + rect1.height))) {
                game.setScreen(new Tank1Screen(game));
            }
            System.out.printf("x: %d  y:%d\n", x, y);
        }

        game.getBatch().begin();
        game.getBatch().draw(tankScreen, 0, 0);
        game.getBatch().end();
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
