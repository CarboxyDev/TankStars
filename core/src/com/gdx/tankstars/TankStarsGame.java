package com.gdx.tankstars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.tankstars.game.TerrainGenerator;
import com.gdx.tankstars.screen.GameMatchScreen;

public class TankStarsGame extends Game {

  private SpriteBatch batch;

  public TankStarsGame() {
  }

  public SpriteBatch getBatch() {
    return batch;
  }

  /* Game Data */

  private int player1;
  private int player2;

  @Override
  public void create() {
    batch = new SpriteBatch();

    //this.setScreen(new TerrainGenerator());
    //this.setScreen(new StartScreen(this));
    this.setScreen(new GameMatchScreen((this)));
  }

  @Override
  public void render() {
    super.render();
  }

  @Override
  public void dispose() {
    batch.dispose();
  }

  public int getPlayer1() {
    return player1;
  }

  public void setPlayer1(int player1) {
    this.player1 = player1;
  }

  public int getPlayer2() {
    return player2;
  }

  public void setPlayer2(int player2) {
    this.player2 = player2;
  }


}
