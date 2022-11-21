package com.gdx.tankstars;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.gdx.tankstars.TankStarsGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {

  public static void main(String[] arg) {
    Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
    config.setForegroundFPS(60);
    config.setIdleFPS(60);
    config.useVsync(true);
    config.setWindowedMode(1280, 720);
    config.setResizable(false);
    config.setTitle("Tank Stars");
    new Lwjgl3Application(new TankStarsGame(), config);
  }
}
