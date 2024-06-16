package nuvola.managers.inputmanager.input;

import java.util.Objects;

public class KeyInput implements Input {
    public final int key;
    public final int action;
    public final int modifier;

    public KeyInput(int key, int action, int modifier) {
        this.key = key;
        this.action = action;
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "Key Input: {key: " + key + ", action: " + action + ", modifier: " + modifier + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyInput keyInput = (KeyInput) o;
        return key == keyInput.key && action == keyInput.action && modifier == keyInput.modifier;
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(key, action, modifier) + 1;
    }
}
