package com.gdx.tankstars.game;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.List;

public class Terrain extends ShapeRenderer {

    private Camera camera;

    public Terrain(Camera camera) {
        this.camera = camera;
    }






    public void generate() {
        TerrainGenerator generator = new TerrainGenerator();
        double[][] terrain = generator.generateTerrain();
        System.out.println(terrain);

        ModelBatch modelBatch = new ModelBatch();

        Material material = new Material();

        material.set(ColorAttribute.createDiffuse(Color.GREEN));
        ArrayList<Vector3> vertices = new ArrayList<Vector3>();
        ArrayList<Short> indices = new ArrayList<Short>();

        for (int x = 0; x < TerrainGenerator.TERRAIN_WIDTH - 1; x++) {
            for (int y = 0; y < TerrainGenerator.TERRAIN_HEIGHT - 1; y++) {
                vertices.add(new Vector3(x, (float) terrain[x][y], y));
                vertices.add(new Vector3(x, (float) terrain[x][y + 1], y + 1));
                vertices.add(new Vector3(x + 1, (float) terrain[x + 1][y + 1], y + 1));
                vertices.add(new Vector3(x + 1, (float) terrain[x + 1][y], y));

                // Add the indices for the current quad
                short offset = (short)(x * TerrainGenerator.TERRAIN_HEIGHT + y);
                indices.add(offset);
                indices.add((short)(offset + 1));
                indices.add((short)(offset + 2));
                indices.add(offset);
                indices.add((short)(offset + 2));
                indices.add((short)(offset + 3));
            }
        }

        float[] verticesArray = new float[vertices.size() * 3];
        for (int i = 0; i < vertices.size(); i++) {
            Vector3 vertex = vertices.get(i);
            verticesArray[i * 3] = vertex.x;
            verticesArray[i * 3 + 1] = vertex.y;
            verticesArray[i * 3 + 2] = vertex.z;
        };

        short[] indicesArray = new short[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            indicesArray[i] = indices.get(i);
        }


        Mesh mesh = new Mesh(true, vertices.size(), indices.size(), new VertexAttribute(VertexAttributes.Usage.Position, 3, "a_position"));


        mesh.setVertices(verticesArray);
        mesh.setIndices(indicesArray);


        ModelBuilder modelBuilder = new ModelBuilder();
        modelBuilder.begin();
        modelBuilder.part("part1", mesh, GL20.GL_TRIANGLES, material);
        Model model = modelBuilder.end();

        ModelInstance modelInstance = new ModelInstance(model);

        modelBatch.begin(this.camera);
        modelBatch.render(modelInstance);
        modelBatch.end();






    }

}
