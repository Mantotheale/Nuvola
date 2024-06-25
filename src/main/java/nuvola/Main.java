package nuvola;

import nuvola.managers.inputmanager.InputManager;
import nuvola.command.CloseGameCommand;
import nuvola.command.Command;
import nuvola.managers.inputmanager.input.KeyInput;
import nuvola.managers.inputmanager.inputlistener.*;
import nuvola.managers.windowmanager.Window;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Trial", 1080, 720);
        InputListener keyListener = new KeyListener(window);
        InputListener clickListener = new ClickListener(window);
        InputListener mouseListener = new MouseListener(window);
        InputListener scrollListener = new ScrollListener(window);

        InputManager manager = new InputManager(List.of(keyListener, clickListener, mouseListener, scrollListener));

        Engine engine = new Nuvola(window, manager);

        Command closeCommand = new CloseGameCommand(engine);
        manager.addMapping(new KeyInput(256, 1, 0), closeCommand);

        engine.run();
        engine.shutdown();
    }
}