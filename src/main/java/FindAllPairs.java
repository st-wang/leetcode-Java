import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllPairs {

    // Given an array and a number,
    // find all the pairs in the array that add up to that number

    public List<Pair<Integer, Integer>> findAllAdjacentPairs(List<Integer> list, int num) {
        if (list.size() <= 1) {
            return Collections.emptyList();
        }

        List<Pair<Integer, Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < list.size() - 1; i++) {
            int first = list.get(i);
            if (first <= num) {
                int second = list.get(i + 1);
                if (second < num && first + second == num) {
                    pairs.add(new Pair<>(first, second));
                }
            }
        }

        return pairs;
    }

    public List<Pair<Integer, Integer>> findAllPairs(List<Integer> list, int num) {
        if (list.size() <= 1) {
            return Collections.emptyList();
        }

        List<Pair<Integer, Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < list.size() - 1; i++) {
            int first = list.get(i);
            if (first <= num) {
                for (int j = i + 1; j < list.size(); j++) {
                    int second = list.get(j);
                    if (second < num && first + second == num) {
                        pairs.add(new Pair<>(first, second));
                    }
                }
            }
        }

        return pairs;
    }
}
