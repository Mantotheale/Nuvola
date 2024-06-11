package nuvola.keytransmitter;

import nuvola.window.IWindow;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class KeyTransmitter implements IKeyTransmitter {
    private final IWindow window;
    private final List<KeyObserver> observers = new ArrayList<>();

    public KeyTransmitter(@NotNull IWindow window) {
        this.window = window;
        window.setKeyCallback(this::keyPressed);
    }

    @Override
    public void addObserver(@NotNull KeyObserver keyObserver) {
        observers.add(keyObserver);
    }

    @Override
    public void removeObserver(@NotNull KeyObserver keyObserver) {
        observers.remove(keyObserver);
    }

    @Override
    public void notifyObservers(@NotNull Key key, @NotNull KeyAction action, @NotNull KeyModifier modifier) {
        for (KeyObserver o: observers)
            o.keyPressed(key, action, modifier);
    }

    public void keyPressed(long window, int key, int scancode, int action, int mods) {
        if (Key.keyExists(key) && KeyAction.glfwKeyActionExists(action)) {
            Key k = Key.fromGlfwKey(key);
            KeyAction a = KeyAction.fromGlfwKeyAction(action);

            KeyModifier m;
            if (KeyModifier.keyModExists(mods))
                m = KeyModifier.fromGlfwKeyMod(mods);
            else
                m = KeyModifier.NONE;

            notifyObservers(k, a, m);
        }
    }
}
