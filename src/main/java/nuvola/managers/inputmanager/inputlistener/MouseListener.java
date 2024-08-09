package nuvola.managers.inputmanager.inputlistener;

import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MouseListener extends InputListener {
    @NotNull private Input lastInput = new Input.NoInput();

    @NotNull private final Window window;

    public MouseListener(@NotNull Window window) {
        this.window = Objects.requireNonNull(window);
        window.setCursorPosCallback(this::mouseMoved);
    }

    public void mouseMoved(long window, double xPos, double yPos) {
        lastInput = new Input.MouseMovementInput(xPos, this.window.height() - yPos - 1);

        notifyObservers();
    }

    @Override
    @NotNull protected Input lastInput() {
        return lastInput;
    }
}
