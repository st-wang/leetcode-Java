package BBLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TwoSum {

    //Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    //Example:
    //Given nums = [2, 7, 8, 11, 15], target = 9,
    //Because nums[0] + nums[1] = 2 + 7 = 9,
    //return [0, 1].

    static class Tuple<E> {
        E first;
        E second;

        Tuple(E e1, E e2) {
            this.first = e1;
            this.second = e2;
        }

        Tuple() {
            this.first = null;
            this.second = null;
        }

        boolean isTupleEmpty() {
            return this.first == null && this.second == null;
        }
    }

    Tuple<Integer> twoSum(List<Integer> list, int target) {
        List<Integer> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.naturalOrder());

        if (target > sortedList.get(sortedList.size() - 1) || target < sortedList.get(0)) {
            return null;
        }

        int flag = target / 2; //4
        int i = 0, j = list.size() - 1;
        Tuple<Integer> tuple = new Tuple<>();

        while (sortedList.get(j) >= target) {
            j--;
        } //j=2, list[j]=8

        while (i <= flag && j >= flag && i != j) {
            int currentSum = sortedList.get(i) + sortedList.get(j); //=2+8=10

            if (currentSum == target) {
                tuple.first = list.indexOf(sortedList.get(i));
                tuple.second = list.indexOf(sortedList.get(j));
                break;
            }
            else if (currentSum > target) {
                j--;
            }
            else {
                i++;
            }
        }

        return tuple.isTupleEmpty() ? null : tuple;
    }
}
