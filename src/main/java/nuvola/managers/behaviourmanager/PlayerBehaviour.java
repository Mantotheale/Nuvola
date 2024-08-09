package nuvola.managers.behaviourmanager;

import nuvola.command.Command;
import nuvola.managers.inputmanager.InputManager;
import nuvola.managers.transform.Transform;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Queue;

public class PlayerBehaviour extends Behaviour {
    @NotNull private final Transform transform;
    @NotNull private final InputManager inputManager;

    public PlayerBehaviour(@NotNull Transform transform, @NotNull InputManager inputManager) {
        this.transform = Objects.requireNonNull(transform);
        this.inputManager = Objects.requireNonNull(inputManager);
    }

    @Override
    public void onFixedUpdate() {
        for (Command c: inputManager.getCommands()) {
            
        }
    }
}
