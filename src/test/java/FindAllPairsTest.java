import javafx.util.Pair;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class FindAllPairsTest {

    FindAllPairs testInstance = new FindAllPairs();

    @Test
    public void find_all_adjacent_pairs() {
        List<Integer> list = asList(2, 1, 2, 3, 0);

        List<Pair<Integer, Integer>> pairs = testInstance.findAllAdjacentPairs(list, 3);

        assertThat(pairs).containsExactly(new Pair<>(2, 1), new Pair<>(1, 2), new Pair<>(3, 0));
    }

    @Test
    public void find_all_pairs() {
        List<Integer> list = asList(2, 1, 2, 3, 0, 2);

        List<Pair<Integer, Integer>> pairs = testInstance.findAllPairs(list, 3);

        assertThat(pairs).containsExactly(new Pair<>(2, 1), new Pair<>(1, 2),
                new Pair<>(1, 2),  new Pair<>(3, 0)
        );
    }
}