package nuvola;

import nuvola.managers.inputmanager.InputManager;
import nuvola.command.CloseGameCommand;
import nuvola.command.Command;
import nuvola.command.PrintCommand;
import nuvola.managers.inputmanager.input.ClickInput;
import nuvola.managers.inputmanager.input.KeyInput;
import nuvola.managers.inputmanager.inputlistener.*;
import nuvola.managers.windowmanager.Window;

import java.util.List;

import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Trial", 1080, 720);
        InputListener keyListener = new KeyListener(window);
        InputListener clickListener = new ClickListener(window);
        InputListener mouseListener = new MouseListener(window);
        InputListener scrollListener = new ScrollListener(window);

        InputManager manager = new InputManager(List.of(keyListener, clickListener, mouseListener, scrollListener));
        clickListener.addObserver(manager);

        Engine engine = new Nuvola(window, manager);
        Command closeCommand = new CloseGameCommand(engine);
        manager.addMapping(new KeyInput(256, 1, 0), closeCommand);
        manager.addMapping(new ClickInput(GLFW_MOUSE_BUTTON_LEFT, 1, 0), new PrintCommand("Bella"));

        engine.run();
        engine.shutdown();
    }
}