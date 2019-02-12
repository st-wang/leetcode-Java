package BBLeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class BestTimeForStock {

    //Best Time to Buy and Sell Stock
    //Say you have an array for which the ith element is the price of a given stock on day i.
    //If you were only permitted to complete at most one transaction -> buy at most once and sell once
    //(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    //Example 1: Input: [7, 1, 5, 3, 6, 4] Output: 5
    //max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
    //
    //Example 2: Input: [7, 6, 4, 3, 1] Output: 0
    //In this case, no transaction is done, i.e. max profit = 0.

    int maxProfitOneTransaction(List<Integer> prices) {
        int profit = 0;

        //The first action is always buying
        //if (isListDescending(prices)) {
        //    return 0;
        //}

        int priceToBuy = prices.get(0);

        for (int price : prices) {
            priceToBuy = Math.min(price, priceToBuy);

            profit = Math.max(price - priceToBuy, profit);
        }

        return profit;
    }


    // It may be a greedy problem let's see this later
    int maxProfitMultipleTransaction(List<Integer> prices) {
        int profit = 0;

        if (isListDescending(prices)) {
            return 0;
        }

        int i = 0, buyDay = 0;

        while (i < prices.size() - 2) {
            if (prices.get(i) >= prices.get(i + 1)) {
                i++;
            } else {
                profit += prices.get(i + 1) - prices.get(i);
            }
        }

        return profit;
    }

    private boolean isListDescending(List<Integer> list) {
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

}
