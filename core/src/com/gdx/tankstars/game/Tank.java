package com.gdx.tankstars.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.gdx.tankstars.TankStarsGame;

public abstract class Tank extends Sprite {

    private float speed = 5.0f;
    private float rotationSpeed = 85.0f;
    private int health = 100;
    private int fuel = 100;
    private int type;
    private Vector2 position;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }


    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }




    public abstract void draw(SpriteBatch batch);
}
