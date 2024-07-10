package nuvola.managers.transform;

import org.jetbrains.annotations.NotNull;
import org.joml.AxisAngle4f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.Objects;

public class Rotation {
    @NotNull private Quaternionf rotation;

    public Rotation(@NotNull Quaternionf rotation) {
        this.rotation = Objects.requireNonNull(rotation);
    }

    public Rotation(@NotNull Vector3f axis, float angle) {
        this(new Quaternionf(new AxisAngle4f(angle, axis)));
    }

    @NotNull public Matrix4f getMatrix() {
        return new Matrix4f().rotate(rotation);
    }

    @NotNull public Matrix4f apply(@NotNull Matrix4f matrix) {
        return matrix.rotate(rotation);
    }

    @NotNull public static Rotation IDENTITY() {
        return new Rotation(new Quaternionf());
    }
}
