package nuvola;

import nuvola.managers.inputmanager.InputManager;
import nuvola.command.CloseGameCommand;
import nuvola.command.Command;
import nuvola.managers.inputmanager.input.KeyInput;
import nuvola.managers.inputmanager.inputlistener.*;
import nuvola.managers.rendermanager.RenderManager;
import nuvola.managers.windowmanager.Window;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Trial", 1080, 720);
        InputListener keyListener = new KeyListener(window);
        InputListener clickListener = new ClickListener(window);
        InputListener mouseListener = new MouseListener(window);
        InputListener scrollListener = new ScrollListener(window);

        InputManager inputManager = new InputManager(List.of(keyListener, clickListener, mouseListener, scrollListener));

        RenderManager renderManager = new RenderManager();

        Engine engine = new Nuvola(window, inputManager, renderManager);

        Command closeCommand = new CloseGameCommand(engine);
        inputManager.addMapping(new KeyInput(256, 1, 0), closeCommand);

        engine.run();
        engine.shutdown();
    }
}