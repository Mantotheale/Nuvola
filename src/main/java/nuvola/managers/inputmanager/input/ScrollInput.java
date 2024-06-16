package nuvola.managers.inputmanager.input;

import java.util.Objects;

public class ScrollInput implements Input {
    public final double vertical;

    public ScrollInput(double vertical) {
        this.vertical = vertical;
    }

    @Override
    public String toString() {
        return "Mouse Scroll Input: {vertical: " + vertical + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrollInput scrollInput = (ScrollInput) o;
        return vertical == scrollInput.vertical;
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(vertical) + 4;
    }
}
