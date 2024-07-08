package nuvola.mapping;

import nuvola.command.Command;
import nuvola.managers.inputmanager.input.Input;

public interface InputToCommandConverter {
    Command convert(Input input);
}
