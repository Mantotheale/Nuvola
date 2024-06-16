package nuvola;


import nuvola.managers.inputmanager.InputManager;
import nuvola.command.Command;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Queue;

public class Nuvola implements Engine {
    private final Window window;
    @NotNull private final InputManager inputManager;

    private boolean shouldClose = false;

    public Nuvola(Window window, @NotNull InputManager inputManager) {
        this.window = window;
        this.inputManager = Objects.requireNonNull(inputManager);
    }

    public void run() {
        while (!shouldClose()) {
            window.pollEvents();

            Queue<Command> commands = inputManager.getCommands();

            for (Command c: commands)
                c.execute();

            inputManager.clearCommands();

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
        return shouldClose || window.shouldClose();
    }
}
