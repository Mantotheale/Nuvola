package nuvola;

import nuvola.window.Window;
import nuvola.window.IWindow;

public class Main {
    public static void main(String[] args) {
        IWindow window = new Window("GameEngine", 1080, 720);

        Engine engine = new Nuvola(window);
        engine.init();
        engine.run();
        engine.shutdown();
    }
}