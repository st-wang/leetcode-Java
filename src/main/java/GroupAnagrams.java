import java.util.*;
import java.util.HashMap;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class GroupAnagrams {
    // Given an array of strings strs, group all anagrams together into sublists.
    // You may return the output in any order.
    //
    // An anagram is a string that contains the exact same characters as another string,
    // but the order of the characters can be different.
    //
    // Example 1:
    // Input: strs = ["act","pots","tops","cat","stop","hat"]
    // Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
    //
    // Example 2:
    // Input: strs = ["x"]
    // Output: [["x"]]
    //
    // Example 3:
    // Input: strs = [""]
    // Output: [[""]]
    //
    // You should aim for a solution with O(m * n) time and O(m) space, m: number of string, n: longest string

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return singletonList(Arrays.asList(strs));
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            System.out.println(s);
            System.out.println(chars);

            String sortedString = Arrays.toString(chars);

            if (map.get(sortedString) == null) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedString, list);
            } else {
                map.get(sortedString).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }
}
