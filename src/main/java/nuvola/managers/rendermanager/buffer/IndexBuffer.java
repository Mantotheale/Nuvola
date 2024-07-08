package nuvola.managers.rendermanager.buffer;

import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.MemoryUtil;

import java.nio.IntBuffer;
import java.util.List;
import java.util.Objects;

import static org.lwjgl.opengl.GL15.*;

public class IndexBuffer {
    private final int id;
    private final int count;

    public IndexBuffer(@NotNull List<Integer> indexList) {
        if (Objects.requireNonNull(indexList).isEmpty())
            throw new IllegalArgumentException("Can't create index buffer with 0 indices");

        count = indexList.size();
        IntBuffer buffer = MemoryUtil.memAllocInt(count);
        for (int i: indexList)
            buffer.put(i);

        id = glGenBuffers();
        bind();
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, buffer.flip(), GL_STATIC_DRAW);
        unbind();

        MemoryUtil.memFree(buffer);
    }

    public int count() {
        return count;
    }

    public void bind() {
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, id);
    }

    public void unbind() {
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
    }
}
