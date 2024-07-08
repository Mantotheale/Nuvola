package nuvola.managers.rendermanager.buffer.vertex.attribute;

import nuvola.managers.rendermanager.buffer.vertex.layout.AttributeLayout;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2f;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.util.Objects;

public record TextureCoordinatesAttribute(@NotNull Vector2f texCoords) implements VertexAttribute {
    public TextureCoordinatesAttribute(@NotNull Vector2f texCoords) {
        this.texCoords = new Vector2f(Objects.requireNonNull(texCoords));
    }

    public TextureCoordinatesAttribute(float u, float v) {
        this(new Vector2f(u, v));
    }

    @Override
    public @NotNull ByteBuffer data() {
        return texCoords.get(MemoryUtil.memAlloc(layout().size()));
    }

    @Override
    public @NotNull AttributeLayout layout() {
        return AttributeLayout.texCoordsLayout();
    }
}
