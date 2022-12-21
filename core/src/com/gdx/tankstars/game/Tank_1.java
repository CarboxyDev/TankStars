package com.gdx.tankstars.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.List;

public class Tank_1 extends Actor {
    private Texture texture;
    private Vector2 position;
    private float speed;
    private float direction;

    public Tank_1(Texture texture, Vector2 position, float speed, float direction) {
        this.texture = texture;
        this.position = position;
        this.speed = speed;
        this.direction = direction;
    }

    public void move() {
        // Update position based on speed and direction
        position.x += speed * Math.cos(direction);
        position.y += speed * Math.sin(direction);

        // Update actor position
        setPosition(position.x, position.y);
    }

    public void handleInput(Input input) {
        // Handle keyboard input to control tank movement
        if (input.isKeyPressed(Input.Keys.LEFT)) {
            this.move();
        }
        if (input.isKeyPressed(Input.Keys.RIGHT)) {
            this.move();
        }
//        if (input.isKeyPressed(Input.Keys.UP)) {
//            speed += 0.1f;
//        }
//        if (input.isKeyPressed(Input.Keys.DOWN)) {
//            speed -= 0.1f;
//        }
    }

    public void checkCollision(List<Terrain_1> ground) {
        ShapeRenderer shapeRenderer = new ShapeRenderer();

        // Draw the terrain as a rectangle


        // Draw the tank as a circle
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.circle(position.x, position.y, texture.getWidth() / 2);
        shapeRenderer.end();

        // Check for collision between the terrain rectangle and tank circle
        for (Terrain_1 terrain : ground){
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.rect(terrain.getBounds().x, terrain.getBounds().y, terrain.getBounds().width, terrain.getBounds().height);
            shapeRenderer.end();
            if (Intersector.overlaps(new Circle(position, texture.getWidth() / 2), terrain.getBounds())) {
                // Calculate new position based on current position, speed, and direction
                float newX = (float) (position.x + speed * Math.cos(direction));
                float newY = (float) (position.y + speed * Math.sin(direction));

                // Check if new position is still colliding with terrain
                if (!Intersector.overlaps(new Circle(new Vector2(newX, newY), texture.getWidth() / 2), terrain.getBounds())) {
                    // Update tank's position
                    position.set(newX, newY);
                    setPosition(position.x, position.y);
                }
            }
        }

    }

    public void draw(SpriteBatch batch, float alpha) {
        batch.draw(texture, position.x, position.y);
    }
}


