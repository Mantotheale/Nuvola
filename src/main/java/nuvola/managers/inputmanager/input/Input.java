package nuvola.managers.inputmanager.input;

import nuvola.managers.windowmanager.Window;

public sealed interface Input {
    record NoInput() implements Input { }

    record ClickInput(int button, int action, int modifier) implements Input { }

    record CloseWindowInput(Window window) implements Input { }

    record KeyInput(int key, int action, int modifier) implements Input { }

    record MouseMovementInput(double xPos, double yPos) implements Input { }

    record ResizeWindowInput(Window window, int width, int height) implements Input { }

    record ScrollInput(double vertical) implements Input { }
}
