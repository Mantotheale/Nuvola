package nuvola.utility;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public final class NuvolaLists {
    private NuvolaLists() { }

    public static <T> T getLast(@NotNull List<T> list) {
        if (Objects.requireNonNull(list).isEmpty())
            throw new IllegalArgumentException("Empty list doesn't contain a last element");

        return list.get(list.size() - 1);
    }
}
