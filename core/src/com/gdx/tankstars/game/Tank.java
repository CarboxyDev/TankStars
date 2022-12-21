package com.gdx.tankstars.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public abstract class Tank extends Sprite {
    private float speed = 5.0f;
    private float rotationSpeed = 85.0f;

    public Tank(Texture texture) {
        super(texture);
    }

    public void move(float deltaTime) {
        translate(getVelocity().x * deltaTime, getVelocity().y * deltaTime);
    }

    public void setVelocity(Vector2 velocity) {
        setVelocity(velocity.x, velocity.y);
    }

    // Set the velocity of the tank
    public void setVelocity(float x, float y) {
        setX(getX() + x);
        setY(getY() + y);
    }

    public Vector2 getVelocity() {
        return new Vector2(getX(), getY());
    }

    // Rotate the tank by the specified angle
    public void rotate(float angle) {
        rotate(angle);
    }


}
