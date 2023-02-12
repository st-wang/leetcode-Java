import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveZerosTest {
    private final MoveZerosToEnd instance = new MoveZerosToEnd();

    @Test
    public void moveZerosToEnd() {
        int[] nums = new int[]{0, 0, 3, 2, 0, 7, 1};
        int[] expected = new int[]{3, 2, 7, 1, 0, 0, 0};

        assertThat(instance.moveZerosToEnd(nums)).isEqualTo(expected);
    }

    @Test
    public void moveZerosToEnd_NoQueue() {
        int[] nums = new int[]{0, 0, 3, 2, 0, 7, 1};
        int[] expected = new int[]{3, 2, 7, 1, 0, 0, 0};

        assertThat(instance.moveZerosToEnd_NoQueue(nums)).isEqualTo(expected);
    }
}