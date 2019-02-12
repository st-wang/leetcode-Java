import java.util.Arrays;

public class HeapSort {

    public int[] sort(int[] array) {
        int[] sortedArray = new int[array.length];
        sortedArray[0] = array[0];

        for (int i = 0; i < array.length; i++) {
            insertAChild(array, i);
        }

        Arrays.stream(array).forEach(System.out::println);

        return sortedArray;
    }

    // create a biggest heap
    private void insertAChild(int[] array, int i) {
        int father = (i - 1) / 2;

        while (father >= 0 && i != 0) {
            if (array[father] < array[i]) {
                array[father] = array[father] + array[i];
                array[i] = array[father] - array[i];
                array[father] = array[father] - array[i];
            }

            i = father;
            father = (i - 1) / 2;
        }
    }

}
