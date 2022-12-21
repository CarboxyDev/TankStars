package com.gdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

public class TempScreen implements Screen {
    private Tank_1 tank;
    List<Terrain_1> ground;

    private SpriteBatch batch;

    public TempScreen() {
        Texture tankTexture = new Texture(Gdx.files.internal("tanks/beast_1.png"));
        tank = new Tank_1(tankTexture, new Vector2(0, 235), 0.5f, 0);
        Texture groundTexture = new Texture(Gdx.files.internal("ground.png"));
        GroundGenerator_1 groundGenerator = new GroundGenerator_1(groundTexture, new Vector2(0, 200), new Vector2(400, 400), new Vector2(800, 500), new Vector2(1280, 300));
        ground = groundGenerator.generateGround();
        batch = new SpriteBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        handleInput();
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        for (Terrain_1 tile : ground) {
            tile.draw(batch);
        }
        tank.draw(batch, 1);
        batch.end();
    }

    private void handleInput() {
        tank.handleInput(Gdx.input);
    }

    private void update(float delta) {
//        tank.move();
        tank.checkCollision(ground);
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
