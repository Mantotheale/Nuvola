package nuvola;

import nuvola.command.ResizeWindowCommand;
import nuvola.managers.inputmanager.InputManager;
import nuvola.command.CloseGameCommand;
import nuvola.command.Command;
import nuvola.managers.inputmanager.input.CloseWindowInput;
import nuvola.managers.inputmanager.input.KeyInput;
import nuvola.managers.inputmanager.input.ResizeWindowInput;
import nuvola.managers.inputmanager.inputlistener.*;
import nuvola.managers.rendermanager.RenderManager;
import nuvola.managers.windowmanager.Window;
import nuvola.mapping.InputCommandMapping;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputCommandMapping mapping = new InputCommandMapping();

        Window window = new Window("Trial", 1080, 720);
        InputListener keyListener = new KeyListener(window);
        InputListener clickListener = new ClickListener(window);
        InputListener mouseListener = new MouseListener(window);
        InputListener scrollListener = new ScrollListener(window);
        InputListener closeListener = new CloseWindowListener(window);
        InputListener resizeListener = new ResizeWindowListener(window);

        window.setClearColor(0.3f, 0.3f, 0.3f);

        InputManager inputManager = new InputManager(List.of(keyListener, clickListener, mouseListener, scrollListener, closeListener, resizeListener), mapping);

        RenderManager renderManager = new RenderManager();

        Engine engine = new Nuvola(window, inputManager, renderManager);


        Command closeCommand = new CloseGameCommand(engine);
        mapping.addMapping(new KeyInput(256, 1, 0), closeCommand);
        mapping.addMapping(new CloseWindowInput(), closeCommand);
        mapping.addDynamicMapping(
                ResizeWindowInput.class,
                input ->  new ResizeWindowCommand(window, ((ResizeWindowInput) input).width,  ((ResizeWindowInput) input).height)
        );

        engine.run();
        engine.shutdown();
    }
}