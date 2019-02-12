import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAdjacentWordsTest {
    private FindAdjacentWords testInstance = new FindAdjacentWords();

    @Test
    public void getAdjacentWordsFrequency() {
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("hey", "you", "hey", "me"));
        ArrayList<String> word = new ArrayList<>(Arrays.asList("hey", "you"));

        assertThat(testInstance.getAdjacentWordsFrequency(stringList, word)).isEqualTo(2);
    }

    @Test
    public void getAdjacentWordsFrequency_2() {
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("This", "is", "a", "test", "is", "other", "a", "test", "is", "a"));
        ArrayList<String> word = new ArrayList<>(Arrays.asList("is", "a", "test"));

        assertThat(testInstance.getAdjacentWordsFrequency(stringList, word)).isEqualTo(4);
    }
}