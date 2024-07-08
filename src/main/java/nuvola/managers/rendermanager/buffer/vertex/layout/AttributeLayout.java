package nuvola.managers.rendermanager.buffer.vertex.layout;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record AttributeLayout(@NotNull OpenGLType glType, int count) {
    public AttributeLayout(@NotNull OpenGLType glType, int count) {
        if (count <= 0)
            throw new IllegalArgumentException("Count of elements in a layout pair must be positive");

        this.glType = Objects.requireNonNull(glType);
        this.count = count;
    }

    public int size() {
        return glType.size() * count;
    }

    @NotNull private final static AttributeLayout positionLayout = new AttributeLayout(OpenGLType.FLOAT, 3);
    @NotNull private final static AttributeLayout colorLayout = new AttributeLayout(OpenGLType.FLOAT, 3);
    @NotNull private final static AttributeLayout texCoordsLayout = new AttributeLayout(OpenGLType.FLOAT, 2);

    @NotNull public static AttributeLayout positionLayout() {
        return positionLayout;
    }

    @NotNull public static AttributeLayout colorLayout() {
        return colorLayout;
    }

    @NotNull public static AttributeLayout texCoordsLayout() {
        return texCoordsLayout;
    }

}
