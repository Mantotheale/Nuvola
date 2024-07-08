package nuvola.managers.rendermanager.shader;

import org.jetbrains.annotations.NotNull;

public class FragmentShader extends Shader {
    public FragmentShader(@NotNull String pathString) {
        super(ShaderType.FRAGMENT, pathString);
    }
}
