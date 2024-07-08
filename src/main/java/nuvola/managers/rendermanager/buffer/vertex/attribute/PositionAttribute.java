package nuvola.managers.rendermanager.buffer.vertex.attribute;

import nuvola.managers.rendermanager.buffer.vertex.layout.AttributeLayout;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.util.Objects;

public record PositionAttribute(@NotNull Vector3f position) implements VertexAttribute {
    public PositionAttribute(@NotNull Vector3f position) {
        this.position = new Vector3f(Objects.requireNonNull(position));
    }

    public PositionAttribute(float x, float y, float z) {
        this(new Vector3f(x, y, z));
    }

    @Override
    public @NotNull ByteBuffer data() {
        return position.get(MemoryUtil.memAlloc(layout().size()));
    }

    @Override
    public @NotNull AttributeLayout layout() {
        return AttributeLayout.positionLayout();
    }
}
