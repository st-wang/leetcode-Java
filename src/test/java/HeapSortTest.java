import org.junit.Test;

public class HeapSortTest {

    private HeapSort test = new HeapSort();

    @Test
    public void sort() {
        int[] array = new int[]{12, 34, 9, 28, 10};

        test.sort(array);
    }
}