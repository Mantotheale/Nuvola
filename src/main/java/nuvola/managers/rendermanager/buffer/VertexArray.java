package nuvola.managers.rendermanager.buffer;

import nuvola.managers.rendermanager.buffer.vertex.layout.LayoutEntry;
import nuvola.managers.rendermanager.buffer.vertex.layout.VertexLayout;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class VertexArray {
    private final int id;
    private final int vertexCount;
    private IndexBuffer indexBuffer;

    public VertexArray(@NotNull VertexBuffer vertexBuffer, @NotNull VertexLayout layout) {
        id = glGenVertexArrays();
        vertexCount = Objects.requireNonNull(vertexBuffer).count();

        bind();
        vertexBuffer.bind();

        int i = 0;
        for (LayoutEntry entry: Objects.requireNonNull(layout)) {
            glVertexAttribPointer(i, entry.count(), entry.glType().openglEnum(), false, layout.size(), entry.offset());
            glEnableVertexAttribArray(i);
            i++;
        }

        unbind();
    }

    public VertexArray(@NotNull VertexBuffer vertexBuffer, @NotNull VertexLayout bufferLayout, @NotNull IndexBuffer indexBuffer) {
        this(vertexBuffer, bufferLayout);
        bindIndexBuffer(Objects.requireNonNull(indexBuffer));
    }

    public void bind() {
        glBindVertexArray(id);
    }

    public void unbind() {
        glBindVertexArray(0);
    }

    public int count() {
        return vertexCount;
    }

    public void bindIndexBuffer(IndexBuffer indexBuffer) {
        bind();
        indexBuffer.bind();
        unbind();
        this.indexBuffer = indexBuffer;
    }

    public void unbindIndexBuffer() {
        bind();
        indexBuffer.unbind();
        unbind();
        this.indexBuffer = null;
    }

    public boolean isIndexBound() { return indexBuffer != null; }

    public int indexCount() {
        return (indexBuffer == null) ? 0 : indexBuffer.count();
    }
}
