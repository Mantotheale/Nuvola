package nuvola.keytransmitter;

import org.jetbrains.annotations.NotNull;

public interface IKeyTransmitter {
    void addObserver(@NotNull KeyObserver keyObserver);
    void removeObserver(@NotNull KeyObserver keyObserver);
    void notifyObservers(@NotNull Key key, @NotNull KeyAction action, @NotNull KeyModifier modifier);
    void keyPressed(long window, int key, int scancode, int action, int mods);
}
