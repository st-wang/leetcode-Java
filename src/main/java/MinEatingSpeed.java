import java.util.Arrays;

import static java.lang.Math.min;

public class MinEatingSpeed {
    // You are given an integer array piles where piles[i] is the number of bananas in the ith pile.
    // You are also given an integer h, which represents the number of hours you have to eat all the bananas.
    //
    // You may decide your bananas-per-hour eating rate of k.
    // Each hour, you may choose a pile of bananas and eats k bananas from that pile.
    // If the pile has less than k bananas, you may finish eating the pile but you can not eat from another pile in the same hour.
    //
    // Return the minimum integer k such that you can eat all the bananas within h hours.
    //    piles.length <= h <= 1,000,000

    //
    // Example 1:
    // Input: piles = [1,4,3,2], h = 9
    // Output: 2
    //
    // Example 2:
    // Input: piles = [25,10,23,4], h = 4
    // Output: 25

    //-----------------------------------------------------------------------------
    // ANALYSIS:
    // It's wrong to calculate an average time spent per pile and calculate all the rest based on this.
    // because it's clear that the eating time on each pile is/should be different and that's the point of this exercise.
    // Given that piles.length <= h, we know that we have at least 1h for each pile.
    // So the max eating speed should be the biggest number among the piles / h. And the theoretic min speed is 1.
    // What we need to do is to find the smallest number in [1, max_number] which satisfies h_spent <= h_given.
    // => find a number in an array which satisfies a certain condition
    //    ==> try numbers one by one: brutal force
    //    ==> binary search


    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int left = 1, right = max;
        int minK = max;

        while (left < right) {
            int k = (left + right) / 2;
            int totalTime = Arrays.stream(piles).map(p -> (int) Math.ceil((double) p / k)).sum();
//            Arrays.stream(piles).forEach(p -> System.out.println("p="+p+" k="+k+"  "+Math.ceil((double) p / k)));
//            Arrays.stream(piles).forEach(p -> System.out.println("p="+p+" k="+k+"  "+(int) Math.ceilDiv(p, k)));

            if (totalTime <= h) { // Eating speed is satisfied, current k is ok, try to get a smaller value for k
                right = k;
                minK = min(k, minK);
            } else {
                left = k + 1;
            }
        }

        return minK;
    }
}
