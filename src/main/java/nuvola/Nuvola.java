package nuvola;


import nuvola.managers.inputmanager.InputManager;
import nuvola.command.Command;
import nuvola.managers.rendermanager.RenderManager;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Queue;

public class Nuvola implements Engine {
    private final Window window;
    @NotNull private final InputManager inputManager;
    @NotNull private final RenderManager renderManager;

    private boolean shouldClose = false;

    public Nuvola(Window window, @NotNull InputManager inputManager, @NotNull RenderManager renderManager) {
        this.window = window;
        this.inputManager = Objects.requireNonNull(inputManager);
        this.renderManager = Objects.requireNonNull(renderManager);
    }

    public void run() {
        while (!shouldClose()) {
            window.pollEvents();
            window.clearColorBuffer();

            Queue<Command> commands = inputManager.getCommands();

            for (Command c: commands)
                c.execute();

            inputManager.clearCommands();

            renderManager.draw();

            window.swapBuffers();
        }
    }

    public void shutdown() {
        window.shutdown();
    }

    public void signalClose() {
        shouldClose = true;
    }

    private boolean shouldClose() {
        return shouldClose;
    }
}
