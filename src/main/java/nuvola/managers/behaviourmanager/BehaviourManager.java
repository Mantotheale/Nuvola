package nuvola.managers.behaviourmanager;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BehaviourManager {
    @NotNull public List<Behaviour> behaviours = new ArrayList<>();

    public void addBehaviour(@NotNull Behaviour behaviour) {
        behaviours.add(Objects.requireNonNull(behaviour));
    }

    public void removeBehaviour(@NotNull Behaviour behaviour) {
        behaviours.remove(behaviour);
    }
}
