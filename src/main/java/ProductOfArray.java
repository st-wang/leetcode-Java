import java.util.Arrays;

public class ProductOfArray {

    // Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
    //Each product is guaranteed to fit in a 32-bit integer.
    //
    //Follow-up: Could you solve it in O(n) time without using the division operation?
    //
    //Example 1:
    //Input: nums = [1,2,4,6]
    //Output: [48,24,12,8]
    //
    //Example 2:
    //Input: nums = [-1,0,1,2,3]
    //Output: [0,-6,0,0,0]

    public int[] productExceptSelf_division(int[] nums) {
        int product = 1;
        int nonZeroProduct = 1;
        boolean allZeros = true;
        int zeros = 0;

//        if (Arrays.stream(nums).anyMatch(value -> value == 0)) {
//
//        }
//        Arrays.stream(nums).reduce(1, (a, b) -> a * b);  // Give up this solution because it seems cool but each loop we add O(n)
        // There is no added-value

        for (int num : nums) {
            if (num != 0) {
                nonZeroProduct *= num;
                allZeros = false;
            } else {
                product = 0;
                zeros++;
            }
        }

        if (allZeros) {
            nonZeroProduct = 0;
        } else if (product == 1) { // product value non changed
            product = nonZeroProduct;
        } else if (zeros > 1) { // more than one 0
            nonZeroProduct = 0;
        }

        int finalNonZeroProduct = nonZeroProduct;
        int finalProduct = product;
        return Arrays.stream(nums).map(value -> value == 0 ? finalNonZeroProduct : finalProduct / value).toArray();
    }


    public int[] productExceptSelf_no_division(int[] nums) {
        // Use 2 arrays and get their products
        // nums =   [1,          2,       4,        6]
        // prefix = [1,          1*1,    (1*1)*2,  (1*1*2)*4]
        // suffix = [(1*6*4)*2, (1*6)*4,  1*6,      1]
        int n = nums.length;
        int[] res = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        suffix[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = nums[i + 1] * suffix[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }

}
