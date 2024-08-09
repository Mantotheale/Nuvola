package nuvola.managers.inputmanager.inputlistener;

import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.inputmanager.InputObserver;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class InputListener {
    @NotNull private final List<InputObserver> observers = new ArrayList<>();

    public void addObserver(@NotNull InputObserver observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    public void removeObserver(@NotNull InputObserver observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    public void notifyObservers(@NotNull Input input) {
        Objects.requireNonNull(input);

        for (InputObserver obs: observers)
            obs.inputOccurred(input);
    }
}
