package nuvola;

import nuvola.systems.inputsystem.inputlistener.InputListener;
import nuvola.systems.inputsystem.inputlistener.KeyListener;
import nuvola.window.Window;

import static org.lwjgl.glfw.GLFW.*;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Trial", 1920, 1080);
        InputListener listener = new KeyListener(window);

        while (!window.shouldClose()) {
            glfwPollEvents();
        }
    }
}