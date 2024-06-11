package nuvola.keytransmitter;

import org.lwjgl.glfw.GLFW;

public enum KeyAction {
    PRESS(GLFW.GLFW_PRESS),
    RELEASE(GLFW.GLFW_RELEASE);

    private int glfwKeyAction;

    KeyAction(int glfwKeyAction) {
        this.glfwKeyAction = glfwKeyAction;
    }

    public int getGlfwKeyAction() {
        return glfwKeyAction;
    }

    public static boolean glfwKeyActionExists(int glfwKeyAction) {
        return glfwKeyAction == GLFW.GLFW_PRESS || glfwKeyAction == GLFW.GLFW_RELEASE;
    }

    public static KeyAction fromGlfwKeyAction(int glfwKeyAction) {
        if (glfwKeyAction == GLFW.GLFW_PRESS)
            return PRESS;

        if (glfwKeyAction == GLFW.GLFW_RELEASE)
            return RELEASE;

        return null;
    }
}
