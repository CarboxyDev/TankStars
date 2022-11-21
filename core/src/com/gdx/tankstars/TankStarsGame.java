package com.gdx.tankstars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.tankstars.screen.StartScreen;

public class TankStarsGame extends Game {

  private SpriteBatch batch;
  private Texture img;

  public SpriteBatch getBatch() {
    return batch;
  }

  public Texture getImg() {
    return img;
  }


  @Override
  public void create() {
    batch = new SpriteBatch();
    this.setScreen(new StartScreen(this));
  }

  @Override
  public void render() {
    super.render();
  }

  @Override
  public void dispose() {
    batch.dispose();
    img.dispose();
  }
}
