import java.util.LinkedList;
import java.util.Queue;

public class MoveZeros {

    // given nums = [0, 1, 0, 3, 12], after calling the function, nums should be [1, 3, 12, 0, 0].
    public int[] moveZerosToEnd (int[] nums) {
        int i = 0;

        Queue<Integer> zeroIndexQueue = new LinkedList<>();

        while (i < nums.length) {
            if (nums[i] == 0) {
                zeroIndexQueue.offer(i);
            }
            else {
                if (!zeroIndexQueue.isEmpty()) {
                    int index = zeroIndexQueue.poll();
                    nums[index] = nums[i];
                    zeroIndexQueue.offer(i);
                }
            }
            i++;
        }

        while (!zeroIndexQueue.isEmpty()) {
            nums[zeroIndexQueue.poll()] = 0;
        }

        return nums;
    }

}
