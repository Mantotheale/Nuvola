package nuvola.managers.rendermanager.buffer.vertex.layout;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record LayoutEntry(@NotNull AttributeLayout pair, int offset) {
    public LayoutEntry(@NotNull AttributeLayout pair, int offset) {
        if (offset < 0)
            throw new IllegalArgumentException("Offset in a layout element must be greater than or equal to 0");

        this.pair = Objects.requireNonNull(pair);
        this.offset = offset;
    }

    @NotNull public OpenGLType glType() {
        return pair.glType();
    }

    public int count() {
        return pair.count();
    }

    public int size() {
        return pair.size();
    }
}
