package nuvola.keytransmitter;

import org.lwjgl.glfw.GLFW;

import java.util.HashMap;
import java.util.Map;

public enum KeyModifier {
    NONE(0),
    SHIFT(GLFW.GLFW_MOD_SHIFT),
    CONTROL(GLFW.GLFW_MOD_CONTROL),
    CONTROL_AND_SHIFT(GLFW.GLFW_MOD_SHIFT | GLFW.GLFW_MOD_CONTROL);

    private final static Map<Integer, KeyModifier> keyModifierMap;

    static {
        keyModifierMap = new HashMap<>();

        for (KeyModifier k: values())
            keyModifierMap.put(k.glfwMod, k);
    }

    private int glfwMod;

    KeyModifier(int glfwMod) {
        this.glfwMod = glfwMod;
    }

    public int getGlfwMod() {
        return glfwMod;
    }

    public static boolean keyModExists(int glfwKeyMod) {
        return keyModifierMap.containsKey(glfwKeyMod);
    }

    public static KeyModifier fromGlfwKeyMod(int glfwKeyMod) {
        return keyModifierMap.getOrDefault(glfwKeyMod, null);
    }
}
