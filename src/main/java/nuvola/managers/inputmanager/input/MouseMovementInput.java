package nuvola.managers.inputmanager.input;

import java.util.Objects;

public class MouseMovementInput implements Input {
    public final double xPos;
    public final double yPos;

    public MouseMovementInput(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public String toString() {
        return "Mouse Movement Input: {xPos: " + xPos + ", yPos: " + yPos + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MouseMovementInput mouseInput = (MouseMovementInput) o;
        return xPos == mouseInput.xPos && yPos == mouseInput.yPos;
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(xPos, yPos) + 3;
    }
}
