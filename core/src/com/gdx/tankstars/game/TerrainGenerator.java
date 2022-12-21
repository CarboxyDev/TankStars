package com.gdx.tankstars.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.gdx.tankstars.TankStarsGame;

public class TerrainGenerator implements Screen {

    private ShapeRenderer shapeRenderer;
    private World world;
    private Body body;
    private Bezier<Vector2> bezierCurve;
    private Box2DDebugRenderer debugRenderer;
    private TankStarsGame game;

    public TerrainGenerator(TankStarsGame game) {
        this.game = game;
        // Initialize the ShapeRenderer object
        shapeRenderer = new ShapeRenderer();

        // Initialize the World object
        world = new World(new Vector2(0, -9.81f), true);

        // Define the Bezier curve
        bezierCurve = new Bezier<>(new Vector2(0, 200), new Vector2(400, 400), new Vector2(800, 150), new Vector2(1280, 420));

        // Set up the physics body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(100, 100);
        PolygonShape shape = new PolygonShape();
        Vector2[] vertices = new Vector2[4];
        vertices[0] = new Vector2(100, 100);
        vertices[1] = new Vector2(200, 50);
        vertices[2] = new Vector2(300, 150);
        vertices[3] = new Vector2(400, 100);
        shape.set(vertices);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.5f;
        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);
        debugRenderer = new Box2DDebugRenderer();


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.getBatch().begin();
        game.getBatch().draw(new Texture(Gdx.files.internal("background.png")), 0, 0);
        game.getBatch().end();

        // Health Bar Player 1 (100% width)
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(210 / 255.0f, 210 / 255.0f, 210 / 255.0f, 1);
        shapeRenderer.rect( 75, Gdx.graphics.getHeight() - 60, 200, 30);
        shapeRenderer.end();

        // Health Meter Player 1 (variable width)
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(247 / 255.0f, 64 / 255.0f, 64 / 255.0f, 1);
        shapeRenderer.rect( 75, Gdx.graphics.getHeight() - 60, 200, 30);
        shapeRenderer.end();

        // Health Bar Player 2 (100% width)
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(210 / 255.0f, 210 / 255.0f, 210 / 255.0f, 1);
        shapeRenderer.rect( Gdx.graphics.getWidth() - (75 + 200), Gdx.graphics.getHeight() - 60, 200, 30);
        shapeRenderer.end();

        // Health Meter Player 2 (variable width)
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(247 / 255.0f, 64 / 255.0f, 64 / 255.0f, 1);
        shapeRenderer.rect( Gdx.graphics.getWidth() - (75 + 200), Gdx.graphics.getHeight() - 60, 200, 30);
        shapeRenderer.end();



        world.step(Gdx.graphics.getDeltaTime(), 6, 2);

        // Render the Bezier curve using ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(57 / 255.0f, 33 / 255.0f, 33 / 255.0f, 1);

        Vector2 prev = bezierCurve.valueAt(new Vector2(), 0);
        for (float t = 0; t <= 1; t += 0.01f) {
            Vector2 curr = bezierCurve.valueAt(new Vector2(), t);
            shapeRenderer.line(prev.x, prev.y, curr.x, curr.y);
            prev = curr;
        }
        shapeRenderer.end();
        Camera camera = new Camera();
        // Render the physics body using Box2D DebugRenderer
        debugRenderer.render(world, camera.combined);




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
