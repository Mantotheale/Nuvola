package nuvola.managers.rendermanager;

import nuvola.managers.rendermanager.shader.ShaderProgram;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;
import org.joml.Math;
import org.joml.Matrix4f;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RenderManager {
    @NotNull private final Window window;
    @NotNull private final List<RenderComponent> components = new ArrayList<>();
    @NotNull private Matrix4f projectionMatrix;
    @NotNull private Matrix4f viewMatrix;
    @NotNull private Matrix4f viewProjection;
    @NotNull private final ShaderProgram shader;

    public RenderManager(ShaderProgram shaderProgram, Window window) {
        this.window = Objects.requireNonNull(window);
        shader = Objects.requireNonNull(shaderProgram);

        projectionMatrix = new Matrix4f().ortho(-100, 100, -100, 100, -100, 100);
        viewMatrix = new Matrix4f();
        viewProjection = projectionMatrix.mul(viewMatrix, new Matrix4f());
    }

    public void addComponent(@NotNull RenderComponent component) {
        components.add(Objects.requireNonNull(component));
    }

    public void removeComponent(@NotNull RenderComponent component) {
        components.remove(component);
    }

    public void draw() {
        for (RenderComponent component: components)
            component.draw(shader, viewProjection);

    }
}
