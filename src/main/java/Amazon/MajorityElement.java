package Amazon;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MajorityElement {

    // Write a function which takes an array and prints the majority element (if it exists), otherwise return -1;
    // A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).
    // Example:
    // Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
    // Output : 4
    //
    // Input : {3, 3, 4, 2, 4, 4, 2, 4}
    // Output : -1

    // solution 1:
    public int findMajorityElement(List<Integer> array) {
        final List<Integer> sortedArray = array.stream().sorted().collect(Collectors.toList());

        HashMap<Integer, Integer> frequencyHashMap = new HashMap<>();

        for (Integer element : array) {
            if (frequencyHashMap.containsKey(element)) {
                frequencyHashMap.replace(element, frequencyHashMap.get(element) + 1);
                if (frequencyHashMap.get(element) > sortedArray.size() / 2) {
                    return element;
                }
            }
            frequencyHashMap.putIfAbsent(element, 1);
        }

        return -1;
    }

    // solution 2:
    public class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int v) {
            this.value = v;
        }
    }

    public int findMajorityElementWithBinaryTree(List<Integer> array) {


        return -1;
    }
}
