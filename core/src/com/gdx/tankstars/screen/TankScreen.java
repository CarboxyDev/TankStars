package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.gdx.tankstars.TankStarsGame;

public class TankScreen implements Screen  {

    private TankStarsGame game;
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
            Rectangle tank1_rect = new Rectangle(835, 302, 118, 118);
            Rectangle tank2_rect = new Rectangle(978,302,118, 118);
            Rectangle tank3_rect = new Rectangle(1126, 302, 118, 118);

            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            if (tank1_rect.contains(x, y)) {
                System.out.println("Select tank 1");
                game.setScreen(new Tank1Screen(game));
                this.tankScreen.dispose();
            }
            else if (tank2_rect.contains(x, y)) {
                System.out.println("Select tank 2");
                game.setScreen(new Tank2Screen(game));
                this.tankScreen.dispose();
            }
            else if (tank3_rect.contains(x, y)) {
                System.out.println("Select tank 3");
                game.setScreen(new Tank3Screen(game));
                this.tankScreen.dispose();
            }
            else {
                System.out.printf("x: %d  y:%d\n", x, y);
            }
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
