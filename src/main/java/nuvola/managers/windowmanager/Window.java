package nuvola.managers.windowmanager;

import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;

import java.util.Objects;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Window {
    private long id;
    private final String title;
    private int width;
    private int height;

    public Window(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;

        if (!glfwInit()) throw new RuntimeException("Couldn't initialize GLFW");

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

        id = glfwCreateWindow(width, height, title, 0, 0);

        if (id == 0) throw new RuntimeException("Failed to open a window");

        glfwMakeContextCurrent(id);
        glfwSwapInterval(1);

        GL.createCapabilities();
        glViewport(0, 0, width, height);
    }

    public void shutdown() {
        glfwTerminate();
    }

    public void pollEvents() {
        glfwPollEvents();
    }

    public void swapBuffers() {
        glfwSwapBuffers(id);
    }

    public boolean shouldClose() {
        return glfwWindowShouldClose(id);
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public void setKeyCallback(@NotNull GLFWKeyCallbackI keyCallback) {
        glfwSetKeyCallback(id, Objects.requireNonNull(keyCallback));
    }

    public void setClickCallback(@NotNull GLFWMouseButtonCallbackI clickCallback) {
        glfwSetMouseButtonCallback(id, Objects.requireNonNull(clickCallback));
    }

    public void setCursorPosCallback(@NotNull GLFWCursorPosCallbackI mouseCallback) {
        glfwSetCursorPosCallback(id, Objects.requireNonNull(mouseCallback));
    }

    public void setScrollCallback(@NotNull GLFWScrollCallbackI scrollCallback) {
        glfwSetScrollCallback(id, Objects.requireNonNull(scrollCallback));
    }

    public void setCloseCallback(@NotNull GLFWWindowCloseCallbackI closeCallback) {
        glfwSetWindowCloseCallback(id, Objects.requireNonNull(closeCallback));
    }
}