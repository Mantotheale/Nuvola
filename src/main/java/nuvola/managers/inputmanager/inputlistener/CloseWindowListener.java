package nuvola.managers.inputmanager.inputlistener;

import nuvola.managers.inputmanager.input.ClickInput;
import nuvola.managers.inputmanager.input.CloseWindowInput;
import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.inputmanager.input.NoInput;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

public class CloseWindowListener extends InputListener {
    @NotNull private Input lastInput = new NoInput();

    public CloseWindowListener(@NotNull Window window) {
        window.setCloseCallback(this::closeWindow);
    }

    public void closeWindow(long window) {
        lastInput = new CloseWindowInput();

        notifyObservers();
    }

    @Override
    @NotNull protected Input lastInput() {
        return lastInput;
    }
}
