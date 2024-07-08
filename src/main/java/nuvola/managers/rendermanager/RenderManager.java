package nuvola.managers.rendermanager;

import nuvola.managers.rendermanager.buffer.vertex.Vertex;
import nuvola.managers.rendermanager.buffer.vertex.attribute.ColorAttribute;
import nuvola.managers.rendermanager.buffer.vertex.attribute.PositionAttribute;
import nuvola.managers.rendermanager.buffer.vertex.attribute.TextureCoordinatesAttribute;
import nuvola.managers.rendermanager.shader.ShaderProgram;
import nuvola.managers.rendermanager.texture.Texture;

import java.util.List;

public class RenderManager {
    private final ShaderProgram shader;
    private final Mesh mesh;

    public RenderManager() {
        shader = new ShaderProgram("src/main/resources/shaders/vertexShaders/vertexShader.vert",
                "src/main/resources/shaders/fragmentShaders/fragmentShader.frag");

        List<Vertex> vertices = List.of(
                new Vertex(List.of(
                        new PositionAttribute(-0.5f, -0.5f, 0),
                        new ColorAttribute(1f, 0f, 0f),
                        new TextureCoordinatesAttribute(0, 0))),
                new Vertex(List.of(
                        new PositionAttribute(0.5f, -0.5f, 0),
                        new ColorAttribute(0f, 1f, 0f),
                        new TextureCoordinatesAttribute(1, 0))),
                new Vertex(List.of(
                        new PositionAttribute(-0.5f, 0.5f, 0),
                        new ColorAttribute(0, 0f, 1f),
                        new TextureCoordinatesAttribute(0, 1))),
                new Vertex(List.of(
                        new PositionAttribute(0.5f, 0.5f, 0),
                        new ColorAttribute(0.5f, 0.5f, 0.5f),
                        new TextureCoordinatesAttribute(1, 1)))
        );

        List<Integer> indices = List.of(0, 1, 2, 2, 1, 3);
        Texture texture = new Texture("src/main/resources/textures/suricati.jpg");
        mesh = new Mesh(vertices, indices, List.of(texture));
    }

    public void draw() {
        mesh.draw(shader);
    }
}
