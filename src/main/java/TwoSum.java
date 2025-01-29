import java.util.Map;
import java.util.HashMap;


public class TwoSum {
    // Given an array of integers nums and an integer target,
    // return the indices i and j such that nums[i] + nums[j] == target and i != j.
    // You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
    // Return the answer with the smaller index first.
    // Input: nums = [4,5,6], target = 10
    // Output: [0,2]
    // Input: nums = [5,5], target = 10
    // Output: [0,1]


    public int[] twoSum_MapSolution(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();  // val -> index

        for (int i = 0; i < nums.length; i++) {
            indices.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (indices.containsKey(diff) && indices.get(diff) != i) {
                return new int[]{i, indices.get(diff)};
            }
        }

        return new int[0];
    }


    public int[] twoSum_DoublePointersSolution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] > target/2) {
                    if (nums[j] >= nums[i]) {
                        j++;
                    } else {
                        if (nums[j] + nums[i] == target) {
                            int arr[] = {i, j};
                            return arr;
                        }
                        j++;
                    }
                } else if (nums[i] < target/2) {
                    if (nums[j] <= nums[i]) {
                        j++;
                    } else {
                        if (nums[j] + nums[i] == target) {
                            int arr[] = {i, j};
                            return arr;
                        }
                        j++;
                    }
                } else {
                    if (nums[j] + nums[i] == target) {
                        int arr[] = {i, j};
                        return arr;
                    }
                    j++;
                }
            }
        }
        int arr[] = {};
        return arr;
    }
}
