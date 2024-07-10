package nuvola.managers.transform;

import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import java.util.Objects;

public class Scale {
    @NotNull private Vector3f scale;

    public Scale(@NotNull Vector3f scale) {
        if (scale.x < 0 || scale.y < 0 || scale.z < 0)
            throw new IllegalArgumentException("Can't create a scale with negative values");

        this.scale = scale;
    }

    public Scale(float x, float y, float z) {
        this(new Vector3f(x, y, z));
    }

    public Scale(float s) {
        this(new Vector3f(s));
    }

    @NotNull public Matrix4f getMatrix() {
        return new Matrix4f().scale(scale);
    }

    @NotNull public Matrix4f apply(@NotNull Matrix4f matrix) {
        return matrix.scale(scale);
    }

    @NotNull public static Scale IDENTITY() {
        return new Scale(1, 1, 1);
    }
}
