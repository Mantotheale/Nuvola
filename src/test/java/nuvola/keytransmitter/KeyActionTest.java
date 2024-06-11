package nuvola.keytransmitter;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import static org.lwjgl.glfw.GLFW.*;

public class KeyActionTest {
    private static final List<Integer> acceptableKeyActions =
            List.of(GLFW_PRESS, GLFW_RELEASE);

    private static final List<KeyAction> acceptableKeyActionsMap =
            List.of(KeyAction.PRESS, KeyAction.RELEASE);

    @Test
    public void values_in_the_acceptable_range_are_stored() {
        for (Integer glfwKeyAction: acceptableKeyActions)
            assertThat(KeyAction.glfwKeyActionExists(glfwKeyAction)).isEqualTo(true);
    }

    @Test
    public void values_in_the_unacceptable_range_are_not_stored() {
        assertThat(KeyAction.glfwKeyActionExists(GLFW_REPEAT)).isEqualTo(false);
    }

    @Test
    public void values_in_the_acceptable_range_are_mapped_correctly() {
        for (int i = 0; i < acceptableKeyActions.size(); i++)
            assertThat(KeyAction.fromGlfwKeyAction(acceptableKeyActions.get(i))).isEqualTo(acceptableKeyActionsMap.get(i));
    }

    @Test
    public void values_in_the_unacceptable_range_are_mapped_to_null() {
        assertThat(KeyAction.fromGlfwKeyAction(GLFW_REPEAT)).isEqualTo(null);
    }
}