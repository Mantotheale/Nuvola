package nuvola.managers.rendermanager.buffer.vertex.layout;

import nuvola.utility.NuvolaLists;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class VertexLayout implements Iterable<LayoutEntry> {
    @NotNull private final List<LayoutEntry> entries;
    private final int size;

    public VertexLayout(@NotNull List<AttributeLayout> attributeLayouts) {
        if (Objects.requireNonNull(attributeLayouts).isEmpty())
            throw new IllegalArgumentException("Can't create an empty Vertex Layout");

        entries = populateList(attributeLayouts);

        LayoutEntry last = NuvolaLists.getLast(entries);
        size = last.offset() + last.size();
    }

    public int size() {
        return size;
    }

    @Override @NotNull public Iterator<LayoutEntry> iterator() {
        return Collections.unmodifiableList(entries).iterator();
    }

    @NotNull private static List<LayoutEntry> populateList(@NotNull List<AttributeLayout> attributeLayouts) {
        List<LayoutEntry> entries = new ArrayList<>();

        for (AttributeLayout l: attributeLayouts) {
            if (entries.isEmpty())
                entries.add(new LayoutEntry(Objects.requireNonNull(l), 0));
            else
                entries.add(new LayoutEntry(
                        Objects.requireNonNull(l),
                        NuvolaLists.getLast(entries).offset() + l.size()
                ));
        }

        return entries;
    }
}