package nuvola.managers.inputmanager.inputlistener;

import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

public class ResizeWindowListener extends InputListener {
    @NotNull private Input lastInput = new Input.NoInput();
    Window window;

    public ResizeWindowListener(@NotNull Window window) {
        window.setWindowSizeCallback(this::resizeWindow); this.window = window;
    }

    public void resizeWindow(long window, int width, int height) {
        lastInput = new Input.ResizeWindowInput(this.window, width, height);

        notifyObservers();
    }

    @Override
    @NotNull protected Input lastInput() {
        return lastInput;
    }
}
