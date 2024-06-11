package nuvola;

public class Nuvola {
    public final static Nuvola INSTANCE = new Nuvola();

    private Window window;

    private Nuvola() { }

    public void init() {
        window = Window.INSTANCE;
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

    public boolean shouldClose() {
        return window.shouldClose();
    }
}
