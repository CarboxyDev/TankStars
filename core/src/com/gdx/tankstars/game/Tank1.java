package com.gdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tank1 extends Tank {

    private Vector2 position;
    Texture tankTexture;

    public Tank1(Vector2 position) {
        super();
         this.tankTexture = new Texture(Gdx.files.internal("tanks/beast_left.png"));
         this.position = position;

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(tankTexture, position.x, position.y);
    }
}
