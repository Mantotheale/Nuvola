package nuvola.managers.rendermanager.buffer;

import nuvola.managers.rendermanager.buffer.vertex.Vertex;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;

import static org.lwjgl.opengl.GL15.*;

public class VertexBuffer {
    private final int id;
    private final int count;

    public VertexBuffer(@NotNull List<Vertex> vertices) {
        if (Objects.requireNonNull(vertices).isEmpty())
            throw new IllegalArgumentException("Can't create vertex buffer with 0 vertices");

        ByteBuffer buffer = MemoryUtil.memAlloc(calculateSize(vertices));

        for (Vertex v: vertices) {
            ByteBuffer b = v.data();

            buffer.put(b);
            MemoryUtil.memFree(b);
        }

        id = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, id);
        glBufferData(GL_ARRAY_BUFFER, buffer.flip(), GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, 0);

        MemoryUtil.memFree(buffer);

        count = vertices.size();
    }

    public void bind() {
        glBindBuffer(GL_ARRAY_BUFFER, id);
    }

    public void unbind() {
        glBindBuffer(GL_ARRAY_BUFFER, 0);
    }

    public int count() {
        return count;
    }

    private static int calculateSize(@NotNull List<Vertex> vertices) {
        int s = 0;

        for (Vertex v: vertices)
            s += v.size();

        return s;
    }
}


