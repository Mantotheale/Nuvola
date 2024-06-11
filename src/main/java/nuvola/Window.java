package nuvola;

import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Window {
    public static Window INSTANCE = new Window();
    private static int initialWidth = 1080;
    private static int initialHeight = 720;

    private long id;
    private int width;
    private int height;

    private Window() { }

    public void init() {
        if (!glfwInit()) throw new RuntimeException("Couldn't initialize GLFW");

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

        width = initialWidth;
        height = initialHeight;
        id = glfwCreateWindow(width, height, "Game", 0, 0);

        if (id == 0) throw new RuntimeException("Failed to open a window");

        glfwMakeContextCurrent(id);
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}