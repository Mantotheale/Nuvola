package nuvola.managers.rendermanager;

import nuvola.managers.rendermanager.shader.ShaderProgram;
import nuvola.managers.transform.Transform;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

import java.util.Objects;

public class RenderComponent {
    @NotNull private final Mesh mesh;
    @NotNull private final Transform transform;

    public RenderComponent(@NotNull Mesh mesh, @NotNull Transform transform) {
        this.mesh = Objects.requireNonNull(mesh);
        this.transform = Objects.requireNonNull(transform);
    }

    public void draw(@NotNull ShaderProgram shader, @NotNull Matrix4f viewProjection) {
        shader.setUniform("mvp", viewProjection.mul(transform.getMatrix(), mvp));

        mesh.draw(shader);
    }

    private final Matrix4f mvp = new Matrix4f();
}
