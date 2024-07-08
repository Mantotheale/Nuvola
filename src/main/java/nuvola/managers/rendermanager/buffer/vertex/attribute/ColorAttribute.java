package nuvola.managers.rendermanager.buffer.vertex.attribute;

import nuvola.managers.rendermanager.buffer.vertex.layout.AttributeLayout;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.util.Objects;

public record ColorAttribute(@NotNull Vector3f color) implements VertexAttribute {
    public ColorAttribute(@NotNull Vector3f color) {
        this.color = new Vector3f(Objects.requireNonNull(color));
    }

    public ColorAttribute(float r, float g, float b) {
        this(new Vector3f(r, g, b));
    }

    @Override
    public @NotNull ByteBuffer data() {
        return color.get(MemoryUtil.memAlloc(layout().size()));
    }

    @Override
    public @NotNull AttributeLayout layout() {
        return AttributeLayout.colorLayout();
    }
}
