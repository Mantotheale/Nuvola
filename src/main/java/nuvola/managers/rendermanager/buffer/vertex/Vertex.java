package nuvola.managers.rendermanager.buffer.vertex;

import nuvola.managers.rendermanager.buffer.vertex.attribute.VertexAttribute;
import nuvola.managers.rendermanager.buffer.vertex.layout.LayoutEntry;
import nuvola.managers.rendermanager.buffer.vertex.layout.VertexLayout;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;

public class Vertex {
    @NotNull private final List<VertexAttribute> attributes;
    @NotNull private final VertexLayout layout;

    public Vertex(@NotNull List<VertexAttribute> attributes) {
        if (Objects.requireNonNull(attributes).isEmpty())
            throw new IllegalArgumentException("Can't create empty vertex");

        this.attributes = attributes;
        this.layout = new VertexLayout(attributes.stream().map(VertexAttribute::layout).toList());
    }

    @NotNull public ByteBuffer data() {
        ByteBuffer buffer = MemoryUtil.memAlloc(layout.size());

        for (VertexAttribute a: attributes) {
            ByteBuffer aBuf = a.data();
            buffer.put(aBuf);
            MemoryUtil.memFree(aBuf);
        }

        return buffer.flip();
    }

    @NotNull public VertexLayout layout() {
        return layout;
    }

    public int size() {
        return layout.size();
    }
}
