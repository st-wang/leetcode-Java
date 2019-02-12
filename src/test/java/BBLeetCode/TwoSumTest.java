package BBLeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumTest {
    TwoSum test = new TwoSum();

    @Test
    public void twoSum() {
        List<Integer> list = Arrays.asList(1, 2, 4, 6, 7, 9, 12, 13, 15);
        TwoSum.Tuple<Integer> expected = new TwoSum.Tuple<>(1, 4);

        assertThat(test.twoSum(list, 9).first).isEqualTo(expected.first);
        assertThat(test.twoSum(list, 9).second).isEqualTo(expected.second);
    }

    @Test
    public void twoSum_2() {
        List<Integer> list = Arrays.asList(1, 6, 7, 0, 12, 4, 5);
        TwoSum.Tuple<Integer> expected = new TwoSum.Tuple<>(1, 5);

        assertThat(test.twoSum(list, 10).first).isEqualTo(expected.first);
        assertThat(test.twoSum(list, 10).second).isEqualTo(expected.second);
    }
}