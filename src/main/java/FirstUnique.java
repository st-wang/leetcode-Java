import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FirstUnique {

    // Find the first unique number in an Integer list
    // [0, 1, 0, 1, 2, 3, 2] -> 1


    public int findFirstUniqueNumber (List<Integer> numberList) {

        ////// Solution 1:
        LinkedHashMap<Integer, Integer> occurMap = new LinkedHashMap<>();

        for (int number: numberList) {  // O(n)
            if (occurMap.containsKey(number) && occurMap.get(number) != 0) {
                occurMap.replace(number, occurMap.get(number), 0);
            }
            occurMap.putIfAbsent(number, 1);
        }

        for (Map.Entry<Integer, Integer> entry: occurMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        ////// Solution 2: O(n * n)
//        for (int n: numberList) {
//            if (numberList.indexOf(n) == numberList.lastIndexOf(n)) {  // O(n * n)
//                return n;
//            }
//        }

        return -1;
    }

    // Find the first unique character in a string
    // "character" -> "h"

    public char findFirstUniqueCharacter (String string) {  // O(n*n)
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);

            if (i == string.lastIndexOf(currentChar)) {
                return currentChar;
            }
        }

        return '\n';
    }
}
