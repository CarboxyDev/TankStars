package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.gdx.tankstars.TankStarsGame;

public class GamePauseScreen implements Screen {
    private TankStarsGame game;
    private Texture pauseScreenTexture;
    private final Rectangle buttonResume = new Rectangle(513, 302, 248, 70);
    private final Rectangle buttonSave = new Rectangle(513, 417, 248, 70);
    private final Rectangle buttonExit = new Rectangle(513, 532, 248, 70);

    public GamePauseScreen(TankStarsGame game) {
        this.game = game;
    }


    @Override
    public void show() {
        pauseScreenTexture = new Texture(Gdx.files.internal("pause-screen.png"));
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            if (buttonResume.contains(x, y)) {
                System.out.println("Press resume button");
                game.setScreen(new GameMatchScreen(game));
                this.dispose();
            }
            else if (buttonSave.contains(x, y)) {
                System.out.println("Press save button");
                this.dispose();
            }
            else if (buttonExit.contains(x, y)) {
                System.out.println("Press exit button");
                System.exit(0);
            }
            else {
                System.out.printf("GamePauseScreen: x: %d  y:%d\n", x, y);
            }

        }

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
