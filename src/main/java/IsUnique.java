import java.util.HashMap;
import java.util.Map;

public class IsUnique {

    // Find if the string has no duplicate character
    // "string"  -> true
    // "strings" -> false

    boolean isStringUnique(String string) {
        Map<Character, Integer> storeMap = new HashMap<>();

//        for (int i = 0; i < string.length(); i++) {
//            storeMap.put(string.charAt(i), i);
//        }
//
//        return storeMap.size() == string.length();

        for (int i = 0; i < string.length(); i++) {
            if (storeMap.containsKey(string.charAt(i))) {
                return false;
            }
            storeMap.putIfAbsent(string.charAt(i), i);
        }

        return true;
    }

    boolean isStringUniqueWithoutExtraSpace(String string) {
        for (int i = 0; i < string.length() - 1; i++) {
            if (i != string.lastIndexOf(string.charAt(i))) {  // O(n*n)
                return false;
            }
        }

        return true;
    }
}
