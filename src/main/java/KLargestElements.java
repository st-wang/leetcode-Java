import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class KLargestElements {

    // Fine first K elements in a number list
    // [1, 3, 5, 7, 2, 9, 0, 4], k = 4, -> [9, 7, 5, 3]

    public List<Integer> findKLargest(List<Integer> list, int k) {
        List<Integer> kLargest = new ArrayList<>(k);

        if (k >= list.size()) {
            return list;
        }

        List<Integer> sortedList = list.stream()
                .sorted()
                .collect(toList());

        Arrays.sort(new List[]{list}, Collections.reverseOrder());

        for (int i = list.size() - 1; i > k + 1; i--) {
            kLargest.add(sortedList.get(i));
        }

        return kLargest;
    }


    public List<Integer> findKLargestWithoutStreamSort(List<Integer> list, int k) {
        // Can use binary tree to sort
        // But selection sort can do too -> O(n*log(n))

        List<Integer> kLargest = new ArrayList<>(k);

        if (k >= list.size()) {
            return list;
        }

        int maxIndex;

        for (int head = 0; head < list.size(); head++) {
            maxIndex = head;
            for (int pointer = head; pointer < list.size(); pointer++) {
                if (list.get(pointer) > list.get(maxIndex)) {
                    maxIndex = pointer;
                }
            }
            if (maxIndex != head) {
                int temp = list.get(maxIndex);
                list.set(maxIndex, list.get(head));
                list.set(head, temp);
            }
        }

        System.out.println(list);

        for (int i = 0; i < k; i++) {
            kLargest.add(list.get(i));
        }

        return kLargest;
    }
}
