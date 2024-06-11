package nuvola.keytransmitter;

import nuvola.window.IWindow;
import org.junit.Test;
import org.lwjgl.glfw.GLFWKeyCallbackI;

import static org.lwjgl.glfw.GLFW.*;
import static org.mockito.Mockito.*;

public class KeyTransmitterTest {
    @Test
    public void transmitter_correctly_sets_its_callback_in_injected_window() {
        IWindow mockWindow = mock(IWindow.class);
        IKeyTransmitter SUT = new KeyTransmitter(mockWindow);

        verify(mockWindow, times(1)).setKeyCallback(any(GLFWKeyCallbackI.class));
    }

    @Test
    public void transmitter_correctly_notifies_observers_when_callback_is_called_with_valid_params() {
        KeyObserver mockObs = mock(KeyObserver.class);
        IWindow mockWindow = mock(IWindow.class);
        IKeyTransmitter SUT = new KeyTransmitter(mockWindow);

        SUT.addObserver(mockObs);
        SUT.keyPressed(0, GLFW_KEY_W, 0, GLFW_PRESS, GLFW_MOD_CONTROL);

        verify(mockObs, times(1)).keyPressed(Key.W, KeyAction.PRESS, KeyModifier.CONTROL);
    }

    @Test
    public void transmitter_does_not_notify_observers_when_callback_is_called_with_invalid_params() {
        KeyObserver mockObs = mock(KeyObserver.class);
        IWindow mockWindow = mock(IWindow.class);
        IKeyTransmitter SUT = new KeyTransmitter(mockWindow);

        SUT.addObserver(mockObs);
        SUT.keyPressed(0, GLFW_KEY_L, 0, GLFW_REPEAT, GLFW_MOD_CONTROL | GLFW_MOD_ALT);

        verify(mockObs, times(0)).keyPressed(any(), any(), any());
    }

    @Test
    public void transmitter_notifies_when_callback_is_called_with_valid_key_and_action() {
        KeyObserver mockObs = mock(KeyObserver.class);
        IWindow mockWindow = mock(IWindow.class);
        IKeyTransmitter SUT = new KeyTransmitter(mockWindow);

        SUT.addObserver(mockObs);
        SUT.keyPressed(0, GLFW_KEY_ESCAPE, 0, GLFW_RELEASE, 0);

        verify(mockObs, times(1)).keyPressed(Key.ESC, KeyAction.RELEASE, KeyModifier.NONE);
    }

    @Test
    public void transmitter_does_not_notify_when_callback_is_called_with_invalid_key() {
        KeyObserver mockObs = mock(KeyObserver.class);
        IWindow mockWindow = mock(IWindow.class);
        IKeyTransmitter SUT = new KeyTransmitter(mockWindow);

        SUT.addObserver(mockObs);
        SUT.keyPressed(0, GLFW_KEY_APOSTROPHE, 0, GLFW_RELEASE, 0);

        verify(mockObs, times(0)).keyPressed(any(), any(), any());
    }

    @Test
    public void transmitter_does_not_notify_when_callback_is_called_with_invalid_action() {
        KeyObserver mockObs = mock(KeyObserver.class);
        IWindow mockWindow = mock(IWindow.class);
        IKeyTransmitter SUT = new KeyTransmitter(mockWindow);

        SUT.addObserver(mockObs);
        SUT.keyPressed(0, GLFW_KEY_S, 0, GLFW_REPEAT, GLFW_MOD_SHIFT);

        verify(mockObs, times(0)).keyPressed(any(), any(), any());
    }

    @Test
    public void transmitter_notifies_with_modifier_none_when_callback_is_called_with_invalid_modifier() {
        KeyObserver mockObs = mock(KeyObserver.class);
        IWindow mockWindow = mock(IWindow.class);
        IKeyTransmitter SUT = new KeyTransmitter(mockWindow);

        SUT.addObserver(mockObs);
        SUT.keyPressed(0, GLFW_KEY_ESCAPE, 0, GLFW_PRESS, GLFW_MOD_ALT);

        verify(mockObs, times(1)).keyPressed(Key.ESC, KeyAction.PRESS, KeyModifier.NONE);
    }
}
