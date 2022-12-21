package com.gdx.tankstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gdx.tankstars.TankStarsGame;
import com.gdx.tankstars.game.GameMatch;
import com.gdx.tankstars.game.TerrainGenerator;

public class GameMatchScreen implements Screen {
    private TankStarsGame game;
    private ShapeRenderer shapeRenderer;
    private Texture backgroundTexture;
    private final Rectangle pauseButton = new Rectangle(1212, 25, 45, 45);
    GameMatch gameMatch;

    public GameMatchScreen(TankStarsGame game) {
        this.game = game;
        shapeRenderer = new ShapeRenderer();
        System.out.println("Player 1 -> Tank " + game.getPlayer1());
        System.out.println("Player 2 -> Tank " + game.getPlayer2());
    }


    @Override
    public void show() {
        backgroundTexture = new Texture(Gdx.files.internal("background-2.png"));
        gameMatch = new GameMatch(game);
        //gameMatch.start();
    }

    @Override
    public void render(float delta) {

        if (Gdx.input.justTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            //System.out.println(x + " | " + y);

            if (pauseButton.contains(x, y)) {
                System.out.println("Select Pause button");
                game.setScreen(new GamePauseScreen(game));
            }

        }

        game.getBatch().begin();
        game.getBatch().draw(new Texture(Gdx.files.internal("background-2.png")), 0, 0);
        game.getBatch().draw(new Texture(Gdx.files.internal("turn-1.png")), 550, 600, 215, 130);
        //game.getBatch().draw(new Texture(Gdx.files.internal("turn-2.png")), 550, 600, 215, 130);
        //gameMatch.drawAssets();
        game.getBatch().end();

        // Health Bar Player 1 (100% width)
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(210 / 255.0f, 210 / 255.0f, 210 / 255.0f, 1);
        shapeRenderer.rect( 120, Gdx.graphics.getHeight() - 73, 200, 30);
        shapeRenderer.end();

        // Health Meter Player 1 (variable width)
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(247 / 255.0f, 64 / 255.0f, 64 / 255.0f, 1);
        shapeRenderer.rect( 120, Gdx.graphics.getHeight() - 73, 200, 30);
        shapeRenderer.end();

        // Health Bar Player 2 (100% width)
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(210 / 255.0f, 210 / 255.0f, 210 / 255.0f, 1);
        shapeRenderer.rect( Gdx.graphics.getWidth() - (120 + 200), Gdx.graphics.getHeight() - 73, 200, 30);
        shapeRenderer.end();

        // Health Meter Player 2 (variable width)
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(247 / 255.0f, 64 / 255.0f, 64 / 255.0f, 1);
        shapeRenderer.rect( Gdx.graphics.getWidth() - (120 + 200), Gdx.graphics.getHeight() - 73, 200, 30);
        shapeRenderer.end();

        // Fuel Meter (100% width)
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(210 / 255.0f, 210 / 255.0f, 210 / 255.0f, 1);
        shapeRenderer.rect( 100, 50, 150, 30);
        shapeRenderer.end();


        // Fuel Meter (variable width)
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(248 / 255.0f, 193 / 255.0f, 47 / 255.0f, 1);
        shapeRenderer.rect( 100, 50, 150, 30);
        shapeRenderer.end();


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
