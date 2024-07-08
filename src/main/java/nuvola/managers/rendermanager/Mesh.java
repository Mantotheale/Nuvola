package nuvola.managers.rendermanager;

import nuvola.managers.rendermanager.buffer.IndexBuffer;
import nuvola.managers.rendermanager.buffer.VertexArray;
import nuvola.managers.rendermanager.buffer.VertexBuffer;
import nuvola.managers.rendermanager.buffer.vertex.Vertex;
import nuvola.managers.rendermanager.buffer.vertex.layout.VertexLayout;
import nuvola.managers.rendermanager.shader.ShaderProgram;
import nuvola.managers.rendermanager.texture.Texture;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.lwjgl.opengl.GL11.*;

public class Mesh {
    @NotNull private final VertexArray vertexArray;
    @NotNull private final List<Texture> textures;
    @NotNull private final List<String> textureNames;

    public Mesh(@NotNull List<Vertex> vertices, @NotNull List<Integer> indices, @NotNull List<Texture> textures) {
        if (Objects.requireNonNull(vertices).isEmpty())
            throw new IllegalArgumentException("Can't create mesh without vertices");

        VertexLayout layout = vertices.get(0).layout();
        vertexArray = new VertexArray(new VertexBuffer(vertices), layout, new IndexBuffer(Objects.requireNonNull(indices)));

        this.textures = new ArrayList<>(Objects.requireNonNull(textures));

        textureNames = new ArrayList<>();
        for (int i = 0; i < textures.size(); i++)
            textureNames.add("texture_" + i);
    }

    public Mesh(@NotNull List<Vertex> vertices, @NotNull List<Integer> indices) {
        this(vertices, indices, new ArrayList<>());
    }

    public void draw(@NotNull ShaderProgram shader) {
        for(int i = 0; i < textures.size(); i++) {
            Texture texture = textures.get(i);
            String name = textureNames.get(i);

            texture.bind();
            shader.setUniform(name, texture.id());
        }

        shader.bind();
        vertexArray.bind();

        glDrawElements(GL_TRIANGLES, vertexArray.indexCount(), GL_UNSIGNED_INT, 0);

        vertexArray.unbind();
        shader.unbind();
    }
}