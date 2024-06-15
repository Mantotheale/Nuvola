package nuvola.systems.inputsystem.input;

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
}
