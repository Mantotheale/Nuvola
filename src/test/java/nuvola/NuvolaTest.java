package nuvola;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class NuvolaTest {
    /*
    @Test
    public void init_calls_init_on_window() {
        IWindow mockWindow = mock(IWindow.class);
        Engine SUT = new Nuvola(mockWindow);

        SUT.init();

        verify(mockWindow, times(1)).init();
        SUT.shutdown();
    }

    @Test
    public void shutdown_calls_shutdown_on_window() {
        IWindow mockWindow = mock(IWindow.class);
        Engine SUT = new Nuvola(mockWindow);

        SUT.init();
        SUT.shutdown();

        verify(mockWindow, times(1)).shutdown();
    }

    @Test
    public void engine_calls_pollEvents_and_swapBuffers_every_cycle() {
        IWindow mockWindow = mock(IWindow.class);
        when(mockWindow.shouldClose())
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);
        Engine SUT = new Nuvola(mockWindow);

        SUT.init();
        SUT.run();
        SUT.shutdown();

        verify(mockWindow, times(2)).pollEvents();
        verify(mockWindow, times(2)).swapBuffers();
    }*/
}
