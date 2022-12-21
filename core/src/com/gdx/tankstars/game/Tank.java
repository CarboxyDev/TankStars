package com.gdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.gdx.tankstars.TankStarsGame;

public abstract class Tank extends Sprite {

    private float speed = 1.0f;
    private float rotationSpeed = 85.0f;
    private int health = 100;
    private int fuel = 100;
    private int type;
    private int player;
    private Vector2 position;
    private Texture tankTexture;


    public void burnFuel() {
        fuel--;
    }

    public int getPlayer() {return player;}

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        String texturePath = "";
        if (type == 1) {
            texturePath = "tanks/blaze_left.png";
            if (player == 2) {
                texturePath = "tanks/blaze_right.png";
            }
        }
        if (type == 2) {
            texturePath = "tanks/frostbite_left.png";
            if (player == 2) {
                texturePath = "tanks/frostbite_right.png";
            }
        }
        if (type == 3) {
            texturePath = "tanks/beast_left.png";
            if (player == 2) {
                texturePath = "tanks/beast_right.png";
            }
        };

        this.tankTexture = new Texture(Gdx.files.internal(texturePath));

        System.out.println("Changed tank " + player + " to type " + type);
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Texture getTankTexture() {
        return tankTexture;
    }

    public void setTankTexture(Texture tankTexture) {
        this.tankTexture = tankTexture;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        if (position.x > 5 && position.x < 1200 && this.getFuel() > 0) {
            this.position = position;
            this.burnFuel();
        }
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

    public int getFuel() {
        return fuel;
    }

    public void refillFuel() {
        this.fuel = 100;
    }
}
