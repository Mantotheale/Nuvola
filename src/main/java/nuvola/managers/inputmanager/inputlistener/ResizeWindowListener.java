package nuvola.managers.inputmanager.inputlistener;

import nuvola.managers.inputmanager.input.ClickInput;
import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.inputmanager.input.NoInput;
import nuvola.managers.inputmanager.input.ResizeWindowInput;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

public class ResizeWindowListener extends InputListener {
    @NotNull private Input lastInput = new NoInput();

    public ResizeWindowListener(@NotNull Window window) {
        window.setWindowSizeCallback(this::resizeWindow);
    }

    public void resizeWindow(long window, int width, int height) {
        lastInput = new ResizeWindowInput(width, height);

        notifyObservers();
    }

    @Override
    @NotNull protected Input lastInput() {
        return lastInput;
    }
}
