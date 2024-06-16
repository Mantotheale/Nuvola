package nuvola.managers.inputmanager.input;

import java.util.Objects;

public class ClickInput implements Input {
    public final int button;
    public final int action;
    public final int modifier;

    public ClickInput(int button, int action, int modifier) {
        this.button = button;
        this.action = action;
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "Click Input: {button: " + button + ", action: " + action + ", modifier: " + modifier + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClickInput clickInput = (ClickInput) o;
        return button == clickInput.button && action == clickInput.action && modifier == clickInput.modifier;
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(button, action, modifier) + 2;
    }
}