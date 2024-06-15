package nuvola.interfaces;

import org.jetbrains.annotations.NotNull;

public interface Observer<T> {
    void update(@NotNull T value);
}
