package nuvola.managers.rendermanager.buffer.vertex.layout;

import static org.lwjgl.opengl.GL11.*;

public enum OpenGLType {
    INT {
        @Override
        public int size() {
            return Integer.BYTES;
        }

        @Override
        public int openglEnum() {
            return GL_INT;
        }
    },
    FLOAT {
        @Override
        public int size() {
            return Float.BYTES;
        }

        @Override
        public int openglEnum() {
            return GL_FLOAT;
        }
    },
    BYTE {
        @Override
        public int size() {
            return Byte.BYTES;
        }

        @Override
        public int openglEnum() {
            return GL_BYTE;
        }
    },
    UNSIGNED_INT {
        @Override
        public int size() {
            return Integer.BYTES;
        }

        @Override
        public int openglEnum() {
            return GL_UNSIGNED_INT;
        }
    };

    public abstract int size();
    public abstract int openglEnum();
}
