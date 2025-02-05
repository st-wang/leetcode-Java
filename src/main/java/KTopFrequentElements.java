import java.util.HashMap;
import java.util.*;

public class KTopFrequentElements {
    // Given an integer array nums and an integer k, return the elements with a frequency of k within the array.
    //The test cases are generated such that the answer is always unique.
    //You may return the output in any order.
    //
    //Example 1:
    //Input: nums = [1,2,2,3,3,3], k = 2
    //Output: [2]
    //Example 2:
    //Input: nums = [7,7], k = 1
    //Output: [7]
    //
    //Constraints:
    //1 <= nums.length <= 10^4.
    //-1000 <= nums[i] <= 1000
    //1 <= k <= number of distinct elements in nums.


    // First instinct: use Map -> 0(n) to add all elements to the map with (element, freq) + 0(n) to find out freq = k elements in the map
    // Try to resolve with sorted array
    public int[] frequentKTimes(int[] nums, int k) {
        if (nums.length == 1) return new int[]{nums[0]};

        Arrays.sort(nums);
        Set<Integer> elements = new HashSet<>();
        int previous = nums[0];
        int freq = 1;

        for (int i = 1; i < nums.length; i++) {
            if (previous == nums[i]) {
                freq++;
                if (i == nums.length - 1 && freq == k) {
                    elements.add(previous);
                }
            } else {
                if (freq == k) {
                    elements.add(previous);
                }
                previous = nums[i];
                freq = 1;
            }
        }
        return elements.isEmpty() ? new int[]{} : elements.stream().mapToInt(Integer::intValue).toArray();
    }


    // Given an integer array nums and an integer k, return the k most frequent elements within the array.
    //The test cases are generated such that the answer is always unique.
    //You may return the output in any order.
    //
    //Example 1:
    //Input: nums = [1,2,2,3,3,3], k = 2
    //Output: [2,3]    ==> 3 appears 3 times, 2 appears 2 times, the top 2 most frequent elements are 3 and 2
    //Example 2:
    //Input: nums = [7,7], k = 1
    //Output: [7]
    //
    //Constraints:
    //1 <= nums.length <= 10^4.
    //-1000 <= nums[i] <= 1000
    //1 <= k <= number of distinct elements in nums.

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return new int[]{nums[0]};

        Arrays.sort(nums);
//        TreeMap<Integer, List<Integer>> elements = new TreeMap<>();
        TreeMap<Integer, Integer> elements = new TreeMap<>();
        int previous = nums[0];
        int freq = 1;

        for (int i = 1; i < nums.length; i++) {
            if (previous == nums[i]) {
                freq++;
                if (i == nums.length - 1) {
                    //elements.computeIfAbsent(freq, value -> new ArrayList<>()).add(previous);  // No added value to save the list, can save only the number
                    elements.put(freq, previous);
                }
            } else {
//                elements.computeIfAbsent(freq, value -> new ArrayList<>()).add(previous);
                elements.put(freq, previous);
                previous = nums[i];
                freq = 1;
                if (i == nums.length - 1) {
//                    elements.computeIfAbsent(freq, value -> new ArrayList<>()).add(previous);
                    elements.put(freq, previous);
                }
            }
        }
        List<Integer> topK = new ArrayList<>();
        int i = 0;
        NavigableMap ascOrdered = elements.descendingMap();
//        int last = elements.lastKey();
//
//        while (i < k) {
//            int numOfElementsPerFreq = elements.get(last).size();
//            if (numOfElementsPerFreq < k - i) {
//                for (int j = 0; j < numOfElementsPerFreq; j++) {
//                    topK.add(elements.get(last).get(j));
//                }
//            } else {
//                for (int j = 0; j < k - i; j++) {
//                    topK.add(elements.get(last).get(j));
//                }
//            }
//            i += numOfElementsPerFreq;
//            last = elements.size() > 1 ? elements.lowerKey(last) : last;
//        }

        int firstKey = (int) ascOrdered.firstKey();
        topK.add((int) ascOrdered.get(firstKey));
        int j = 1;
        while (j < k) {
            int lowerKey = (int) ascOrdered.lowerKey(firstKey);
            topK.add((int) ascOrdered.get(lowerKey));
            firstKey = lowerKey;
        }

        return topK.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] topKFrequentReferenceSolution(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>(); // Use arrays inside a list to call Arrays.sort() after
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            arr.add(new int[]{entry.getValue(), entry.getKey()}); // Reverse (key, value) pair in map to make the value (frequency) first
        }
        arr.sort((a, b) -> b[0] - a[0]); // a, b are arrays, the first value of the arrays are frequency
        // b[0] - a[0] means sort by the first value of each array with ascending order
        // then the arrays are sorted by the frequency with ascending order

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}
