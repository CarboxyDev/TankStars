package com.gdx.tankstars.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import javax.swing.text.AbstractDocument;


public class TerrainGenerator_1 implements Screen {
    SpriteBatch batch;
    Texture texture;
    ShapeRenderer shapeRenderer;
    World world;
    Body body;
    Body bodym;
    Sprite sprite;

    Bezier<Vector2> bezierCurve;
    Box2DDebugRenderer debugRenderer;

    public TerrainGenerator_1() {
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
        vertices[0] = new Vector2(0, 200);
        vertices[1] = new Vector2(400, 400);
        vertices[2] = new Vector2(800, 150);
        vertices[3] = new Vector2(1280, 420);
        shape.set(vertices);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.5f;
        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);

        // Define the shape and properties of the body
        BodyDef bodyDef1 = new BodyDef();
        bodyDef1.type = BodyDef.BodyType.DynamicBody;
        bodyDef1.position.set(400, 400);

// Create the shape for the body
        PolygonShape shape1 = new PolygonShape();
        shape1.setAsBox(35, 25);

// Define the body's properties
        FixtureDef fixtureDef1 = new FixtureDef();
        fixtureDef1.shape = shape1;
        fixtureDef1.density = 1.0f;
        fixtureDef1.friction = 0.5f;
        fixtureDef1.restitution = 0.5f;

        bodym = world.createBody(bodyDef1);
        bodym.createFixture(fixtureDef1);

        // Create a SpriteBatch to draw the image
        batch = new SpriteBatch();

// Load the PNG image
        texture = new Texture(Gdx.files.internal("tanks/beast.png"));

// Create a Sprite for the image
        sprite = new Sprite(texture);
        sprite.setSize(75,50);

// Set the Sprite's position to the body's position
        Vector2 pos = bodym.getPosition();
        sprite.setPosition(pos.x, pos.y);



        debugRenderer = new Box2DDebugRenderer();


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);

        // Render the Bezier curve using ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(65, 44, 44, 1);
        Vector2 prev = bezierCurve.valueAt(new Vector2(), 0);
        for (float t = 0; t <= 1; t += 0.01f) {
            Vector2 curr = bezierCurve.valueAt(new Vector2(), t);
            shapeRenderer.line(prev.x, prev.y, curr.x, curr.y);
            prev = curr;
        }

        shapeRenderer.end();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            // Move the bodym to the left
            bodym.setLinearVelocity(-100, 0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            // Move the bodym to the right
            bodym.setLinearVelocity(100, 0);
        }
            else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            // Move the bodym to the right
            bodym.setLinearVelocity(0, -100);
        }
            else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                // Move the bodym to the right
                bodym.setLinearVelocity(0, 100);
            }
        else {
            // Stop the bodym if no keys are pressed
            bodym.setLinearVelocity(0, 0);
        }

        // Set the Sprite's position to the body's position
        Vector2 pos = bodym.getPosition();
        sprite.setPosition(pos.x, pos.y);
        bodym.setTransform(pos, body.getAngle());

        Camera camera = new Camera();

        batch.begin();
        sprite.draw(batch);
        batch.end();
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
