package nuvola.systems.inputmanager.input;

public class NoInput implements Input {
    @Override
    public String toString() {
        return "No input";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof NoInput;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
