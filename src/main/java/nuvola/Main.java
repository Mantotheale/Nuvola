package nuvola;

import nuvola.systems.inputmanager.InputManager;
import nuvola.systems.inputmanager.command.PrintCommand;
import nuvola.systems.inputmanager.input.KeyInput;
import nuvola.systems.inputmanager.inputlistener.InputListener;
import nuvola.systems.inputmanager.inputlistener.KeyListener;
import nuvola.systems.inputmanager.mapping.InputCommandMapping;
import nuvola.window.Window;

import static org.lwjgl.glfw.GLFW.*;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Trial", 1080, 720);
        InputListener listener = new KeyListener(window);
        InputCommandMapping mapping = new InputCommandMapping();
        mapping.addMapping(new KeyInput(256, 1, 0), new PrintCommand("Bella"));
        InputManager manager = new InputManager(listener, mapping);

        while (!window.shouldClose()) {
            glfwPollEvents();
        }
    }
}