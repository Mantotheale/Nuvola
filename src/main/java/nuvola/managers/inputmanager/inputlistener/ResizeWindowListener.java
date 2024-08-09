package nuvola.managers.inputmanager.inputlistener;

import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ResizeWindowListener extends InputListener {

    public ResizeWindowListener(@NotNull Window window) {
        Objects.requireNonNull(window).setWindowSizeCallback(this::resizeWindow);
    }

    public void resizeWindow(long window, int width, int height) {
        notifyObservers(new Input.ResizeWindowInput(width, height));
    }
}
