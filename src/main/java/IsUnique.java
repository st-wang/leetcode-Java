import java.util.HashMap;
import java.util.Map;

public class IsUnique {

    // Find if the string has no duplicate character
    boolean isStringUnique(String string) {
        Map<Character, Integer> storeMap = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            storeMap.put(string.charAt(i), i);
        }

        return storeMap.size() == string.length();
    }

    boolean isStringUniqueWithoutExtraSpace(String string) {
        for (int i = 0; i < string.length() - 1; i++) {
            if (i != string.lastIndexOf(string.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
