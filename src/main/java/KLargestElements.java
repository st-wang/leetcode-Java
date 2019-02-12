import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class KLargestElements {

    public List<Integer> findKLargest (List<Integer> list, int k) {
        List<Integer> kLargest = new ArrayList<>(k);

        if (k > list.size()) {
            return list;
        }

        List<Integer> sortedList = list.stream() //
                .sorted() //
                .collect(toList());

        Arrays.sort(new List[]{list}, Collections.reverseOrder());

        for (int i = list.size() - 1; i > k + 1; i--) {
            kLargest.add(sortedList.get(i));
        }

        return kLargest;
    }
}
