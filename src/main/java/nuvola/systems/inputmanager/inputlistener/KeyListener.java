package nuvola.systems.inputmanager.inputlistener;

import nuvola.systems.inputmanager.input.Input;
import nuvola.systems.inputmanager.input.KeyInput;
import nuvola.systems.inputmanager.input.NoInput;
import nuvola.window.Window;
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
