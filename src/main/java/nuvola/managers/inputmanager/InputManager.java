package nuvola.managers.inputmanager;

import nuvola.command.Command;
import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.inputmanager.inputlistener.InputListener;
import nuvola.mapping.InputCommandMapping;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class InputManager extends InputObserver {
    @NotNull private final Queue<Command> frameCommands = new ArrayDeque<>();
    @NotNull private final InputCommandMapping mapping;

    public InputManager(List<InputListener> listeners, @NotNull InputCommandMapping mapping) {
        for (InputListener listener: listeners)
            listener.addObserver(this);

        this.mapping = mapping;
    }

    @NotNull public Queue<Command> getCommands() {
        return frameCommands;
    }

    public void clearCommands() {
        frameCommands.clear();
    }

    @Override
    public void inputOccurred(@NotNull Input input) {
        frameCommands.add(mapping.convertInput(input));
    }
}
