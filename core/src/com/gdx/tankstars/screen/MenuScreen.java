package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gdx.tankstars.TankStarsGame;

public class MenuScreen implements Screen {

    TankStarsGame game;
    private ShapeRenderer shapeRenderer;
    Texture menuScreen;
    Texture tank1Screen;
    Texture button1;


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
        if (Gdx.input.isTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            // handle event when button-1 is clicked
            Rectangle rect1 = new Rectangle();
            rect1.x = 875;
            rect1.y = 42;
            rect1.width = 333;
            rect1.height = 87;
            if ((x > rect1.x && x < (rect1.x + rect1.width)) && (y > rect1.y && y < (rect1.y + rect1.height))) {
                System.out.printf("clicked button x: %d  y: %d\n", x, y);
                game.setScreen(new Tank1Screen(game));
            }

        }

        game.batch.begin();
        game.batch.draw(menuScreen, 0, 0);
        game.batch.draw(button1, 875, 590);
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
