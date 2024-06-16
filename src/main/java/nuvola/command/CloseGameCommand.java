package nuvola.command;

import nuvola.Engine;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CloseGameCommand implements Command {
    @NotNull private final Engine engine;

    public CloseGameCommand(@NotNull Engine engine) {
        this.engine = Objects.requireNonNull(engine);
    }

    @Override
    public void execute() {
        engine.signalClose();
    }
}
