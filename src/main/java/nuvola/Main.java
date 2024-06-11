package nuvola;

public class Main {
    public static void main(String[] args) {
        Nuvola engine = Nuvola.INSTANCE;
        engine.init();
        engine.run();
        engine.shutdown();
    }
}