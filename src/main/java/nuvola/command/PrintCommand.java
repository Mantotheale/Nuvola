package nuvola.command;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PrintCommand implements Command {
    @NotNull private final String message;

    public PrintCommand(@NotNull String message) {
        this.message = Objects.requireNonNull(message);
    }
    @Override
    public void execute() {
        System.out.println(message);
    }
}
