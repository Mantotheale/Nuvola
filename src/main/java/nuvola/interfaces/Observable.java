package nuvola.interfaces;

import org.jetbrains.annotations.NotNull;

public interface Observable<T> {
    void addObserver(@NotNull Observer<T> observer);
    void removeObserver(@NotNull Observer<T> observer);
    void notifyObservers();
}
