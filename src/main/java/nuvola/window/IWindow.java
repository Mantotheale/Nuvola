package nuvola.window;

import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFWKeyCallbackI;

public interface IWindow {
    void init();
    void shutdown();
    void pollEvents();
    void swapBuffers();
    boolean shouldClose();
    int width();
    int height();

    void setKeyCallback(@NotNull GLFWKeyCallbackI keyCallback);
}
