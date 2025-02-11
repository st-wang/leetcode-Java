package String;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ReverseWordsTest {
    private ReverseWords test = new ReverseWords();

    @Test
    public void reverseWords() {
        String s = "  hello   world  ";

        assertThat(test.reverseWords(s)).isEqualTo("world hello");
    }

    @Test
    public void reverseWords_2() {
        String s = "the sky is blue ";

        assertThat(test.reverseWords(s)).isEqualTo("blue is sky the");
    }

    @Test
    public void reverseWords_O1() {
        String s = "the sky is blue ";

        assertThat(test.reverseWords_O1Space(s)).isEqualTo("blue is sky the");
    }

    @Test
    public void reverseWords_O1_2() {
        String s = "a good   example is this";

        assertThat(test.reverseWords_O1Space(s)).isEqualTo("this is example good a");
    }

    @Test
    public void reverseWords_O1_best() {
        String s = "a good   example is this";

        assertThat(test.reverseWords_best(s)).isEqualTo("this is example good a");
    }
}