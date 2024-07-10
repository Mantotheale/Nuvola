package nuvola.managers.transform;

import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import java.util.Objects;

public class Position {
    @NotNull private Vector3f position;

    public Position(@NotNull Vector3f position) {
        this.position = Objects.requireNonNull(position);
    }

    public Position(float x, float y, float z) {
        this(new Vector3f(x, y, z));
    }

    @NotNull public Matrix4f getMatrix() {
        return new Matrix4f().translate(position);
    }

    @NotNull public Matrix4f apply(@NotNull Matrix4f matrix) {
        return matrix.translate(position);
    }

    @NotNull public static Position ORIGIN() {
        return new Position(0, 0, 0);
    }
}
