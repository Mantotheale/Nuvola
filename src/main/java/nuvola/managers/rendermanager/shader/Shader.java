package nuvola.managers.rendermanager.shader;

import nuvola.utility.NuvolaFileUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;

public abstract class Shader {
    private final int id;
    @NotNull private final ShaderType type;

    private boolean isDeleted;

    protected Shader(@NotNull ShaderType type, @NotNull String pathString) {
        this.type = Objects.requireNonNull(type);

        String content = NuvolaFileUtils.fileToString(Objects.requireNonNull(pathString));

        id = glCreateShader(type.glType());
        glShaderSource(id, content);
        glCompileShader(id);

        if (glGetShaderi(id, GL_COMPILE_STATUS) == GL_FALSE)
            throw new RuntimeException(glGetShaderInfoLog(id));
        isDeleted = false;
    }

    public int id() {
        return id;
    }

    public void delete() {
        glDeleteShader(id);
        isDeleted = true;
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}