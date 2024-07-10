package nuvola.managers.transform;

import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

import java.util.Objects;

public record Transform(@NotNull Position position, @NotNull Scale scale, @NotNull Rotation rotation) {
    public Transform(@NotNull Position position, @NotNull Scale scale, @NotNull Rotation rotation) {
        this.position = Objects.requireNonNull(position);
        this.scale = Objects.requireNonNull(scale);
        this.rotation = Objects.requireNonNull(rotation);
    }

    @NotNull public Matrix4f getMatrix() {
        return rotation.apply(scale.apply(position.apply(new Matrix4f())));
    }

    @NotNull public static Transform IDENTITY() {
        return new Transform(Position.ORIGIN(), Scale.IDENTITY(), Rotation.IDENTITY());
    }
}
