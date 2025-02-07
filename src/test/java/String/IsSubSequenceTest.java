package String;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsSubSequenceTest {
    private final IsSubSequence instance = new IsSubSequence();

    @Test
    public void is_subsequence() {
        String string = "banana";
        String subString = "nan";

        assertThat(instance.isSubsequence(subString, string)).isTrue();
    }

    @Test
    public void is_subsequence_2() {
        String string = "banana";
        String subString = "bnn";

        assertThat(instance.isSubsequence(subString, string)).isTrue();
    }

    @Test
    public void is_subsequence_3() {
        String string = "apple";
        String subString = "pel";

        assertThat(instance.isSubsequence(subString, string)).isFalse();
    }
}