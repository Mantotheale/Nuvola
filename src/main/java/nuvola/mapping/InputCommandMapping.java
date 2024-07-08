package nuvola.mapping;

import nuvola.command.Command;
import nuvola.command.NoCommand;
import nuvola.command.ResizeWindowCommand;
import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.inputmanager.input.ResizeWindowInput;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InputCommandMapping {
    @NotNull private final Map<Input, Command> mapping = new HashMap<>();
    @NotNull private final Map<Class<? extends Input>, InputToCommandConverter> dynamicMapping = new HashMap<>();

    public void addMapping(@NotNull Input input, @NotNull Command command) {
        mapping.put(Objects.requireNonNull(input), Objects.requireNonNull(command));
    }

    public void addDynamicMapping(Class<? extends Input> inputType, InputToCommandConverter converter) {
        dynamicMapping.put(inputType, converter);
    }

    public void removeMapping(@NotNull Input input) {
        mapping.remove(input);
    }

    public void removeDynamicMapping(@NotNull Class<Input> inputType) {
        dynamicMapping.remove(inputType);
    }

    @NotNull public Command convertInput(@NotNull Input input) {
        Command command = mapping.get(input);

        if (command != null)
            return command;

        InputToCommandConverter converter = dynamicMapping.getOrDefault(input.getClass(), (x) -> new NoCommand());
        return converter.convert(input);
    }
}
