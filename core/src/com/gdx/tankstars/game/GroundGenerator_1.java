package com.gdx.tankstars.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class GroundGenerator_1 {
    private static final int GROUND_WIDTH = 100;
    private static final int GROUND_HEIGHT = 10;

    private Texture groundTexture;
    private Bezier<Vector2> borderCurve;

    public GroundGenerator_1(Texture groundTexture, Vector2 startPoint, Vector2 controlPoint1, Vector2 controlPoint2, Vector2 endPoint) {
        this.groundTexture = groundTexture;
        borderCurve = new Bezier<>(startPoint, controlPoint1, controlPoint2, endPoint);
    }

    public List<Terrain_1> generateGround() {
        List<Terrain_1> ground = new ArrayList<>();

        // Generate ground tiles along the border curve
        Vector2 previousTile = borderCurve.valueAt(new Vector2(),0);
        for (float t = 0.1f; t < 1; t += 0.1f) {
            Vector2 currentTile = borderCurve.valueAt(new Vector2(), t);
            float distance = previousTile.dst(currentTile);
            int numTiles = (int) (distance / GROUND_WIDTH);
            for (int i = 0; i < numTiles; i++) {
                float x = previousTile.x + (currentTile.x - previousTile.x) * (float) i / numTiles;
                float y = previousTile.y + (currentTile.y - previousTile.y) * (float) i / numTiles;
                ground.add(new Terrain_1(groundTexture, new Vector2(x, y)));
            }
           
        }

        return ground;
    }
}
