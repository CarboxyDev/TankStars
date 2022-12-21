package com.gdx.tankstars.game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.Vector2;


public class TerrainGenerator_1 implements Screen {

    ShapeRenderer shapeRenderer;

    Bezier<Vector2> bezierCurve;

    public TerrainGenerator_1() {
        shapeRenderer = new ShapeRenderer();
        bezierCurve = new Bezier<>(new Vector2(100, 100), new Vector2(200, 50), new Vector2(300, 150), new Vector2(400, 100));

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1, 1, 1, 1);

        Vector2 prev = bezierCurve.valueAt(new Vector2(), 0);
        for (float t = 0; t <= 1; t += 0.01f) {
            Vector2 curr = bezierCurve.valueAt(new Vector2(), t);
            shapeRenderer.line(prev.x, prev.y, curr.x, curr.y);
            prev = curr;
        }

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
