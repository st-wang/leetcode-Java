import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 3) {
            if (Arrays.stream(nums).sum() == 0) {
                return List.of(Arrays.asList(nums[0], nums[1], nums[2]));
            }
            return Collections.emptyList();
        }

        List<Integer> sorted = Arrays.stream(nums).sorted().boxed().toList();
        System.out.println(sorted);
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < sorted.size(); i++) {
            int j = i + 1, k = sorted.size() - 1;
            while (j < k) {
                if (sorted.get(i) + sorted.get(j) + sorted.get(k) == 0) {
                    res.add(List.of(sorted.get(i), sorted.get(j), sorted.get(k)));
                    j++;
                } else if (sorted.get(k) + sorted.get(j) > -sorted.get(i)) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return res.stream().toList();
    }
}
