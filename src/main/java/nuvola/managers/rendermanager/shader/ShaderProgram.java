package nuvola.managers.rendermanager.shader;

import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryStack;

import java.nio.FloatBuffer;
import java.util.Objects;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;

public class ShaderProgram {
    private final int id;

    public ShaderProgram(@NotNull VertexShader vertexShader, @NotNull FragmentShader fragmentShader) {
        id = glCreateProgram();

        attachShader(Objects.requireNonNull(vertexShader));
        attachShader(Objects.requireNonNull(fragmentShader));

        link();

        detachShader(vertexShader);
        detachShader(fragmentShader);

        vertexShader.delete();
        fragmentShader.delete();
    }

    public ShaderProgram(@NotNull String vertexShaderPath, @NotNull String fragmentShaderPath) {
        this(new VertexShader(vertexShaderPath), new FragmentShader(fragmentShaderPath));
    }

    public void bind() {
        glUseProgram(id);
    }

    public void unbind() {
        glUseProgram(0);
    }

    public void delete() {
        glDeleteProgram(id);
    }

    public void setUniform(String name, boolean value) {
        bind();
        glUniform1i(getUniformLocation(name), Boolean.compare(value, false));
        unbind();
    }

    public void setUniform(String name, int value) {
        bind();
        glUniform1i(getUniformLocation(name), value);
        unbind();
    }

    public void setUniform(String name, float value) {
        bind();
        glUniform1f(getUniformLocation(name), value);
        unbind();
    }

    public void setUniform(String name, float x, float y, float z) {
        bind();
        glUniform3f(getUniformLocation(name), x, y, z);
        unbind();
    }

    public void setUniform(String name, Vector3f value) {
        bind();
        glUniform3f(getUniformLocation(name), value.x, value.y, value.z);
        unbind();
    }

    public void setUniform(String name, Matrix4f value) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            FloatBuffer buffer =  value.get(stack.mallocFloat(16));

            bind();
            glUniformMatrix4fv(getUniformLocation(name), false, buffer);
            unbind();
        }
    }

    public void attachShader(@NotNull Shader shader) {
        glAttachShader(id, shader.id());
    }

    public void detachShader(@NotNull Shader shader) {
        glDetachShader(id, shader.id());
    }

    public void link() {
        glLinkProgram(id);

        if(glGetProgrami(id, GL_LINK_STATUS) == GL_FALSE)
            throw new RuntimeException(glGetProgramInfoLog(id));
    }

    private int getUniformLocation(String name) {
        int location = glGetUniformLocation(id, name);

        if (location == -1)
            throw new IllegalArgumentException("An uniform with name " + name + " doesn't exist in shader " + id);

        return location;
    }
}