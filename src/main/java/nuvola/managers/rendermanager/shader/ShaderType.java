package nuvola.managers.rendermanager.shader;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public enum ShaderType {
    VERTEX {
        @Override
        public int glType() {
            return GL_VERTEX_SHADER;
        }
    },
    FRAGMENT {
        @Override
        public int glType() {
            return GL_FRAGMENT_SHADER;
        }
    };

    public abstract int glType();
}
