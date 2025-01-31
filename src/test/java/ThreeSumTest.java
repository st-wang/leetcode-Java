import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ThreeSumTest {
    private final ThreeSum test = new ThreeSum();

    @Test
    public void three_sum() {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> res = test.threeSum(nums);
        assertThat(res).isEqualTo(List.of(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)));
    }
}