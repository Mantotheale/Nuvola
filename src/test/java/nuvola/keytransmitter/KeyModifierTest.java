package nuvola.keytransmitter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import static org.lwjgl.glfw.GLFW.*;

public class KeyModifierTest {
    private static final List<Integer> acceptableMods =
            List.of(GLFW_MOD_CONTROL, GLFW_MOD_SHIFT, 0, GLFW_MOD_CONTROL | GLFW_MOD_SHIFT);

    private static final List<KeyModifier> acceptableModsMap =
            List.of(KeyModifier.CONTROL, KeyModifier.SHIFT, KeyModifier.NONE, KeyModifier.CONTROL_AND_SHIFT);

    private static final List<Integer> unacceptableMods =
            List.of(GLFW_MOD_ALT, GLFW_MOD_SUPER, GLFW_MOD_CAPS_LOCK, GLFW_MOD_NUM_LOCK);

    @Test
    public void values_in_the_acceptable_range_are_stored() {
        for (Integer glfwKeyMod: acceptableMods)
            assertThat(KeyModifier.keyModExists(glfwKeyMod)).isEqualTo(true);
    }

    @Test
    public void values_in_the_unacceptable_range_are_not_stored() {
        for (Integer glfwKeyMod: unacceptableMods)
            assertThat(KeyModifier.keyModExists(glfwKeyMod)).isEqualTo(false);
    }

    @Test
    public void values_in_the_acceptable_range_are_mapped_correctly() {
        for (int i = 0; i < acceptableMods.size(); i++)
            assertThat(KeyModifier.fromGlfwKeyMod(acceptableMods.get(i))).isEqualTo(acceptableModsMap.get(i));
    }

    @Test
    public void values_in_the_unacceptable_range_are_mapped_to_null() {
        for (Integer glfwKeyMod: unacceptableMods)
            assertThat(KeyModifier.fromGlfwKeyMod(glfwKeyMod)).isEqualTo(null);
    }
}