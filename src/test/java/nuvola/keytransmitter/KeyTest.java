package nuvola.keytransmitter;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import static org.lwjgl.glfw.GLFW.*;

public class KeyTest {
    private static final List<Integer> acceptableKeys =
            List.of(GLFW_KEY_W, GLFW_KEY_A, GLFW_KEY_S, GLFW_KEY_D, GLFW_KEY_ESCAPE);

    private static final List<Key> acceptableKeysMap =
            List.of(Key.W, Key.A, Key.S, Key.D, Key.ESC);

    private static final List<Integer> unacceptableKeys =
            List.of(GLFW_KEY_R, GLFW_KEY_T, GLFW_KEY_CAPS_LOCK, GLFW_KEY_LEFT_ALT, GLFW_KEY_ENTER);

    @Test
    public void values_in_the_acceptable_range_are_stored() {
        for (Integer glfwKey: acceptableKeys)
            assertThat(Key.keyExists(glfwKey)).isEqualTo(true);
    }

    @Test
    public void values_in_the_unacceptable_range_are_not_stored() {
        for (Integer glfwKey: unacceptableKeys)
            assertThat(Key.keyExists(glfwKey)).isEqualTo(false);
    }

    @Test
    public void values_in_the_acceptable_range_are_mapped_correctly() {
        for (int i = 0; i < acceptableKeys.size(); i++)
            assertThat(Key.fromGlfwKey(acceptableKeys.get(i))).isEqualTo(acceptableKeysMap.get(i));
    }

    @Test
    public void values_in_the_unacceptable_range_are_mapped_to_null() {
        for (Integer glfwKey: unacceptableKeys)
            assertThat(Key.fromGlfwKey(glfwKey)).isEqualTo(null);
    }
}