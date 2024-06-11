package nuvola;

import nuvola.window.IWindow;

public class Nuvola implements Engine {
    private final IWindow window;

    public Nuvola(IWindow window) {
        this.window = window;
    }

    public void init() {
        window.init();
    }

    public void run() {
        while (!shouldClose()) {
            window.pollEvents();

            window.swapBuffers();
        }
    }

    public void shutdown() {
        window.shutdown();
    }

    private boolean shouldClose() {
        return window.shouldClose();
    }
}
