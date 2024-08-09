package nuvola.managers.inputmanager.inputlistener;

import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MouseListener extends InputListener {
    @NotNull private final Window window;

    public MouseListener(@NotNull Window window) {
        this.window = Objects.requireNonNull(window);
        window.setCursorPosCallback(this::mouseMoved);
    }

    public void mouseMoved(long window, double xPos, double yPos) {
        notifyObservers(new Input.MouseMovementInput(xPos, this.window.height() - yPos - 1));
    }
}
