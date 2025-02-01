import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class KLargestElementsTest {
    private final KLargestElements testInstance = new KLargestElements();

    @Test
    public void findKLargest() {
        List<Integer> list = new ArrayList<>(asList(1, 3, 5, 7, 2, 9, 0, 4));
        int k = 3;

        assertThat(testInstance.findKLargest(list, k)).isEqualTo(asList(9, 7, 5));
    }

    @Test
    public void findKLargest_2() {
        List<Integer> list = new ArrayList<>(asList(1, 3, 5, 7, 2, 9, 0, 4));
        int k = 3;

        assertThat(testInstance.findKLargestWithoutStreamSort(list, k)).isEqualTo(asList(9, 7, 5));
    }
}