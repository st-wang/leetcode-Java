import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class IsAnagramTest {

    @Test
    public void isAnagram() {
        IsAnagram test = new IsAnagram();

        String s = "apple";
        String t = "lepap";

        assertThat(test.isAnagram(s, t)).isTrue();
    }
}