import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RemoveDuplicateLettersTest {
    private RemoveDuplicateLetters testInstance = new RemoveDuplicateLetters();

    @Test
    public void testRemoveDuplicateLetters() {
        String testString = "apple";
        String targetString = "aple";

        assertThat(testInstance.removeDuplicateLetters(testString)).isEqualTo(targetString);
    }

    @Test
    public void testRemoveDuplicateLetters_2() {
        String testString = "apples are not all red";
        String targetString = "aples rnotd";

        assertThat(testInstance.removeDuplicateLetters(testString)).isEqualTo(targetString);
    }

    @Test
    public void remove_consecutive_chars() {
        String s = "aabbbbaccd";
        String target = "ccd";

        assertThat(testInstance.removeConsecutiveAdjacentCharacters(s)).isEqualTo(target);
    }

    @Test
    public void remove_consecutive_chars_2() {
        String s = "beeddcccdebb";
        String target = "";

        assertThat(testInstance.removeConsecutiveAdjacentCharacters(s)).isEqualTo(target);
    }
}