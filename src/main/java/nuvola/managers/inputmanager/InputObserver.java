package nuvola.managers.inputmanager;

import nuvola.managers.inputmanager.input.Input;
import org.jetbrains.annotations.NotNull;

public abstract class InputObserver {
    public abstract void inputOccurred(@NotNull Input input);
}
