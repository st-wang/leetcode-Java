import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MoveZerosToEnd {

    // Given nums = [0, 1, 0, 3, 12], after calling the function, nums should be [1, 3, 12, 0, 0].
    public int[] moveZerosToEnd(int[] nums) {
        int i = 0;

        Queue<Integer> zeroIndexQueue = new LinkedList<>();
        /*
        * add() - Inserts the specified element into the queue. If the task is successful, add() returns true, if not it throws an exception.
          offer() - Inserts the specified element into the queue. If the task is successful, offer() returns true, if not it returns false.
          element() - Returns the head of the queue. Throws an exception if the queue is empty.
          peek() - Returns the head of the queue. Returns null if the queue is empty.
          remove() - Returns and removes the head of the queue. Throws an exception if the queue is empty.
          poll() - Returns and removes the head of the queue. Returns null if the queue is empty.
        *
        */

        while (i < nums.length) {
            if (nums[i] == 0) {
                zeroIndexQueue.offer(i);
            } else {
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

    public int[] moveZerosToEnd_NoQueue(int[] nums) {
        int i = 0;

        int zeros = 0;

        while (i < nums.length) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                int m = nums[i];
                nums[i] = nums[i - zeros];
                nums[i - zeros] = m;
            }
            i++;
        }

        return nums;
    }

    public int[] moveZerosToEnd_newNums(int[] nums) {
        int i = 0;

        List<Integer> numList = new ArrayList<>();
        int[] newNums = new int[nums.length];

        while (i < nums.length) {
            if (nums[i] != 0) {
                numList.add(nums[i]);
            }
            i++;
        }

        for (int j = 0; j < numList.size(); j++) {
            newNums[j] = numList.get(i);
        }

        return newNums;
    }
}
