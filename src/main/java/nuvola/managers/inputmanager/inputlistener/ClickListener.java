package nuvola.managers.inputmanager.inputlistener;

import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

public class ClickListener extends InputListener {
    @NotNull private Input lastInput = new Input.NoInput();

    public ClickListener(@NotNull Window window) {
        window.setClickCallback(this::buttonPressed);
    }

    public void buttonPressed(long window, int key, int action, int mods) {
        lastInput = new Input.ClickInput(key, action, mods);

        notifyObservers();
    }

    @Override
    @NotNull protected Input lastInput() {
        return lastInput;
    }
}
