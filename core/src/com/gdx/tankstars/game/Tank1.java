package com.gdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tank1 extends Tank {

    Texture tankTexture;



    public Tank1(Vector2 position) {
        super();
        this.tankTexture = new Texture(Gdx.files.internal("tanks/beast_left.png"));
        this.setPosition(position);

    }

    @Override
    public void draw(SpriteBatch batch) {
        Vector2 position = this.getPosition();
        batch.draw(tankTexture, position.x, position.y);
    }



}
