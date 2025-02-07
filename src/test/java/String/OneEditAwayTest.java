package String;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class OneEditAwayTest {
    private OneEditAway testInstance = new OneEditAway();

    @Test
    public void testOneEdit() {
        String s1 = "apple";
        String s2 = "aple";

        assertThat(testInstance.oneEdit(s1, s2)).isTrue();
    }
}