package nuvola.managers.inputmanager.input;

import java.util.Objects;

public class CloseWindowInput implements Input {
    @Override
    public String toString() {
        return "Close Window Input: {}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return 5;
    }
}