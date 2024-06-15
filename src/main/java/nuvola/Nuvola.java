package nuvola;


import nuvola.window.Window;

public class Nuvola {
    private final Window window;
    private boolean shouldClose = false;

    public Nuvola(Window window) {
        this.window = window;
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

    public void signalClose() {
        shouldClose = true;
    }

    private boolean shouldClose() {
        return shouldClose || window.shouldClose();
    }
}
