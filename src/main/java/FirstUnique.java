import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FirstUnique {

    // Find the first unique number in an Integer list
    public int findFirstUniqueNumber (List<Integer> numberList) {
        LinkedHashMap<Integer, Integer> occurMap = new LinkedHashMap<>();

        for (int number: numberList) {
            if (occurMap.containsKey(number)) {
                occurMap.replace(number, occurMap.get(number), occurMap.get(number) + 1);
            }
            occurMap.putIfAbsent(number, 1);
        }

        for (Map.Entry<Integer, Integer> entry: occurMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    // Find the first unique character in a string
    public char findFirstUniqueCharacter (String string) {
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);

            if (string.indexOf(currentChar) == string.lastIndexOf(currentChar)) {
                return currentChar;
            }
        }

        return '\n';
    }
}
