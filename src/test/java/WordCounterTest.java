import static java.util.Map.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import org.junit.Test;

public class WordCounterTest {
    private WordCounter testInstance = new WordCounter();

    @Test
    public void wordCounter() {
        List<String> testList = new ArrayList<>(Arrays.asList("app", "app", "lyn", "po", "app", "po"));
        HashMap<String, Integer> resultMap = testInstance.wordCounter(testList);

        //Map<String, Integer> map = Map.of("app", 3, "lyn", 1);

        for (Entry entry: resultMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}