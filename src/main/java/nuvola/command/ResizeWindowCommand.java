package nuvola.command;

import nuvola.Engine;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ResizeWindowCommand implements Command {
    @NotNull private final Window window;
    private final int width;
    private final int height;

    public ResizeWindowCommand(@NotNull Window window, int width, int height) {
        this.window = Objects.requireNonNull(window);

        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Window width and size can't be 0 or less pixels");

        this.width = width;
        this.height = height;
    }

    @Override
    public void execute() {
        window.setSize(width, height);
    }
}
