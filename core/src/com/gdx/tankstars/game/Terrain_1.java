package com.gdx.tankstars.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Terrain_1 {
    private Texture texture;
    private Vector2 position;
    private Rectangle bounds;

    public Rectangle getBounds() {
        return bounds;
    }

    public Terrain_1(Texture texture, Vector2 position) {
        this.texture = texture;
        this.position = position;
        bounds = new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }
}

