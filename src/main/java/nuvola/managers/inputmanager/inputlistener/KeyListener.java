package nuvola.managers.inputmanager.inputlistener;

import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.inputmanager.input.KeyInput;
import nuvola.managers.inputmanager.input.NoInput;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

public class KeyListener extends InputListener {
    @NotNull private Input lastInput = new NoInput();

    public KeyListener(@NotNull Window window) {
        window.setKeyCallback(this::keyPressed);
    }

    public void keyPressed(long window, int key, int scancode, int action, int mods) {
        lastInput = new KeyInput(key, action, mods);

        notifyObservers();
    }

    @Override
    @NotNull protected Input lastInput() {
        return lastInput;
    }
}
