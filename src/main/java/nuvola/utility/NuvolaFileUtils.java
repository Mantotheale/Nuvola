package nuvola.utility;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class NuvolaFileUtils {
    private NuvolaFileUtils() { }

    @NotNull public static String fileToString(@NotNull String filePathString) {
        Path filePath = Path.of(Objects.requireNonNull(filePathString));

        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file " + filePath);
        }
    }
}
