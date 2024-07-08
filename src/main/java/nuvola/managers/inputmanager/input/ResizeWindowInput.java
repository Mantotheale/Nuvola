package nuvola.managers.inputmanager.input;

import nuvola.managers.windowmanager.Window;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ResizeWindowInput implements Input {
    public final int width;
    public final int height;

    public ResizeWindowInput(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Resize Window Input: {width: " + width + ", height: " + height + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResizeWindowInput resizeInput = (ResizeWindowInput) o;
        return width == resizeInput.width && height == resizeInput.height;
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(width, height) + 6;
    }
}