package nuvola.managers.rendermanager.buffer.vertex.attribute;

import nuvola.managers.rendermanager.buffer.vertex.layout.AttributeLayout;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public interface VertexAttribute {
    @NotNull ByteBuffer data();
    @NotNull AttributeLayout layout();
}
