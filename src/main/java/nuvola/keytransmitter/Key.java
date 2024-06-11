package nuvola.keytransmitter;

import org.lwjgl.glfw.GLFW;

import java.util.HashMap;
import java.util.Map;

public enum Key {
    W(GLFW.GLFW_KEY_W),
    A(GLFW.GLFW_KEY_A),
    S(GLFW.GLFW_KEY_S),
    D(GLFW.GLFW_KEY_D),
    ESC(GLFW.GLFW_KEY_ESCAPE);

    private final static Map<Integer, Key> keyMap;

    static {
        keyMap = new HashMap<>();

        for (Key k: values())
            keyMap.put(k.glfwKey, k);
    }

    Key(int glfwKey) {
        this.glfwKey = glfwKey;
    }

    private final int glfwKey;

    public int getGlfwKey() {
        return glfwKey;
    }

    public static boolean keyExists(int glfwKey) {
        return keyMap.containsKey(glfwKey);
    }

    public static Key fromGlfwKey(int glfwKey) {
        return keyMap.getOrDefault(glfwKey, null);
    }
}
