package nuvola.managers.inputmanager.inputlistener;

import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

public class CloseWindowListener extends InputListener {
    @NotNull private Input lastInput = new Input.NoInput();
    private final Window window;

    public CloseWindowListener(@NotNull Window window) {
        window.setCloseCallback(this::closeWindow); this.window = window;
    }

    public void closeWindow(long window) {
        lastInput = new Input.CloseWindowInput(this.window);

        notifyObservers();
    }

    @Override
    @NotNull protected Input lastInput() {
        return lastInput;
    }
}
