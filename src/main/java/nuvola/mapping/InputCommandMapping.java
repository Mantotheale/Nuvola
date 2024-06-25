package nuvola.mapping;

import nuvola.command.Command;
import nuvola.command.NoCommand;
import nuvola.managers.inputmanager.input.Input;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InputCommandMapping {
    @NotNull private final Map<Input, Command> mapping = new HashMap<>();

    public void addMapping(@NotNull Input input, @NotNull Command command) {
        mapping.put(Objects.requireNonNull(input), Objects.requireNonNull(command));
    }

    public void removeMapping(@NotNull Input input) {
        mapping.remove(input);
    }

    @NotNull public Command convertInput(@NotNull Input input) {
        System.out.println(input);
        return mapping.getOrDefault(input, new NoCommand());
    }
}
