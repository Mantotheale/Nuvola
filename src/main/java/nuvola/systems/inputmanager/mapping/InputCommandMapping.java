package nuvola.systems.inputmanager.mapping;

import nuvola.systems.inputmanager.command.Command;
import nuvola.systems.inputmanager.command.NoCommand;
import nuvola.systems.inputmanager.input.Input;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InputCommandMapping {
    @NotNull private final Map<Input, Command> mapping = new HashMap<>();

    public void addMapping(@NotNull Input input, @NotNull Command command) {
        mapping.put(Objects.requireNonNull(input), Objects.requireNonNull(command));
    }

    @NotNull public Command convertInput(@NotNull Input input) {
        return mapping.getOrDefault(input, new NoCommand());
    }
}
