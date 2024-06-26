package nuvola.managers.inputmanager.inputlistener;

import nuvola.managers.inputmanager.input.Input;
import nuvola.managers.inputmanager.input.NoInput;
import nuvola.managers.inputmanager.input.ScrollInput;
import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

public class ScrollListener extends InputListener {
    @NotNull private Input lastInput = new NoInput();

    public ScrollListener(@NotNull Window window) {
        window.setScrollCallback(this::mouseScrolled);
    }

    public void mouseScrolled(long window, double xOffset, double yOffset) {
        lastInput = new ScrollInput(yOffset);

        notifyObservers();
    }

    @Override
    @NotNull protected Input lastInput() {
        return lastInput;
    }
}
