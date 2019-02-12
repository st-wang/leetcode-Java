import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveZerosTest {
    private MoveZeros instance = new MoveZeros();

    @Test
    public void moveZerosToEnd() {
        int[] nums = new int[]{0, 0, 3, 2, 0, 7, 1};
        int[] expected = new int[]{3, 2, 7, 1, 0, 0, 0};

        assertThat(instance.moveZerosToEnd(nums)).isEqualTo(expected);
    }
}