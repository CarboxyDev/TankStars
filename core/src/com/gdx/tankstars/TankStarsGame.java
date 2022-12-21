package com.gdx.tankstars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.tankstars.game.TerrainGenerator_1;
import com.gdx.tankstars.screen.StartScreen;

public class TankStarsGame extends Game {

  private SpriteBatch batch;

  public SpriteBatch getBatch() {
    return batch;
  }


  @Override
  public void create() {
    batch = new SpriteBatch();
    this.setScreen(new TerrainGenerator_1());
  }

  @Override
  public void render() {
    super.render();
  }

  @Override
  public void dispose() {
    batch.dispose();
  }
}
