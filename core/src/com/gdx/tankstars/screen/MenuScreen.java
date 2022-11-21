package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gdx.tankstars.TankStarsGame;

public class MenuScreen implements Screen {

    private TankStarsGame game;
    private ShapeRenderer shapeRenderer;
    private Texture menuScreen;
    private Texture button1;


    public MenuScreen(TankStarsGame game) {
        this.game = game;
    }


    @Override
    public void show() {
        menuScreen = new Texture(Gdx.files.internal("menu-screen.png"));
        button1 = new Texture(Gdx.files.internal("button-1.png"));
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            Rectangle button1_rect = new Rectangle(875, 42, 333, 87);

            float x = Gdx.input.getX();
            float y = Gdx.input.getY();

            if (button1_rect.contains(x, y)) {
                game.setScreen(new Tank1Screen(game));
                button1.dispose();
            }
        }

        game.getBatch().begin();
        game.getBatch().draw(menuScreen, 0, 0);
        game.getBatch().draw(button1, 875, 590);
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
