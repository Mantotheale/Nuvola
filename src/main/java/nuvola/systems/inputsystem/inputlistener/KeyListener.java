package nuvola.systems.inputsystem.inputlistener;

import nuvola.systems.inputsystem.input.Input;
import nuvola.systems.inputsystem.input.KeyInput;
import nuvola.systems.inputsystem.input.NoneInput;
import nuvola.window.Window;
import org.jetbrains.annotations.NotNull;

public class KeyListener extends InputListener {
    @NotNull private Input lastInput = new NoneInput();

    public KeyListener(@NotNull Window window) {
        window.setKeyCallback(this::keyPressed);
    }

    public void keyPressed(long window, int key, int scancode, int action, int mods) {
        lastInput = new KeyInput(key, action, mods);

        notifyObservers();
    }

    @Override
    @NotNull public Input lastInput() {
        return lastInput;
    }
}
