package nuvola.systems.inputmanager;

import nuvola.interfaces.Observable;
import nuvola.interfaces.Observer;
import nuvola.systems.inputmanager.input.Input;
import nuvola.systems.inputmanager.mapping.InputCommandMapping;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class InputManager implements Observer<Input> {
    @NotNull private final InputCommandMapping mapping;

    public InputManager(Observable<Input> subject, @NotNull InputCommandMapping mapping) {
        this.mapping = Objects.requireNonNull(mapping);
        subject.addObserver(this);
    }

    @Override
    public void update(@NotNull Input value) {
        mapping.convertInput(value).execute();
    }
}
