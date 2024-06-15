package nuvola.systems.inputmanager.inputlistener;

import nuvola.interfaces.Observable;
import nuvola.interfaces.Observer;
import nuvola.systems.inputmanager.input.Input;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class InputListener implements Observable<Input> {
    @NotNull private final List<Observer<Input>> observers = new ArrayList<>();

    @Override
    public void addObserver(@NotNull Observer<Input> observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public void removeObserver(@NotNull Observer<Input> observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public void notifyObservers() {
        for (Observer<Input> obs: observers) {
            obs.update(lastInput());
        }
    }

    @NotNull protected abstract Input lastInput();
}
