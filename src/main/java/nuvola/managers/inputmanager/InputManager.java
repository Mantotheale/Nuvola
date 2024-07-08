package nuvola.managers.inputmanager;

import nuvola.interfaces.Observable;
import nuvola.interfaces.Observer;
import nuvola.command.Command;
import nuvola.managers.inputmanager.input.Input;
import nuvola.mapping.InputCommandMapping;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class InputManager implements Observer<Input> {
    @NotNull private final Queue<Command> frameCommands = new ArrayDeque<>();
    @NotNull private final InputCommandMapping mapping;

    public InputManager(List<Observable<Input>> subjects, @NotNull InputCommandMapping mapping) {
        for (Observable<Input> subject: subjects)
            subject.addObserver(this);

        this.mapping = mapping;
    }

    @Override
    public void update(@NotNull Input value) {
        frameCommands.add(mapping.convertInput(value));
    }

    @NotNull public Queue<Command> getCommands() {
        return frameCommands;
    }

    public void clearCommands() {
        frameCommands.clear();
    }
}
