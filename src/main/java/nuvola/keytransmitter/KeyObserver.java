package nuvola.keytransmitter;

public interface KeyObserver {
    void keyPressed(Key key, KeyAction action, KeyModifier modifier);
}