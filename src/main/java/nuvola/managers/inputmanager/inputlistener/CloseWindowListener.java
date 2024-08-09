package nuvola.managers.inputmanager.inputlistener;

import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CloseWindowListener extends InputListener {
    public CloseWindowListener(@NotNull Window window) {
        Objects.requireNonNull(window).setCloseCallback(this::closeWindow);
    }

    public void closeWindow(long window) {
        notifyObservers(new Input.CloseWindowInput());
    }
}
