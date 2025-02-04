import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class KTopFrequentElementsTest {
    private KTopFrequentElements test = new KTopFrequentElements();

    @Test
    public void frequentKTimes() {
        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;

        assertThat(test.frequentKTimes(nums, k)).isEqualTo(new int[]{2});
    }

    @Test
    public void frequentKTimes_2() {
        int[] nums = {7, 7};
        int k = 1;

        assertThat(test.frequentKTimes(nums, k)).isEqualTo(new int[]{7});
    }

    @Test
    public void topKFrequentElements_1() {
        int[] nums = {1, 2, 2, 3, 3, 2};
        int k = 2;

        assertThat(test.topKFrequent(nums, k)).containsExactlyInAnyOrder(2, 3);
    }

    @Test
    public void topKFrequentElements_2() {
        int[] nums = {7, 7};
        int k = 1;

        assertThat(test.topKFrequent(nums, k)).isEqualTo(new int[]{7});
    }

    @Test
    public void topKFrequentElementsReferenceSolution_1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        assertThat(test.topKFrequentReferenceSolution(nums, k)).containsExactlyInAnyOrder(1, 2);
    }
}