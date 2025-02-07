package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.String.valueOf;

public class RemoveDuplicateLetters {

    // "apple" -> "aple"
    public String removeDuplicateLetters(String string) {
        StringBuilder nonDuplicateStringBuilder = new StringBuilder();
        nonDuplicateStringBuilder.append(string);

        HashSet<Character> characterHashSet = new HashSet<>();

        for (int j = 0; j < string.length(); j++) {
            characterHashSet.add(string.charAt(j));
        }

        int i = 0;
        char currentChar = '\n';
        while (nonDuplicateStringBuilder.indexOf(valueOf(currentChar))
                != nonDuplicateStringBuilder.length() - 1) {

            currentChar = nonDuplicateStringBuilder.charAt(i);

            if (characterHashSet.contains(currentChar)) {
                characterHashSet.remove(currentChar);
                i++;
            } else {
                nonDuplicateStringBuilder.deleteCharAt(i);
            }
        }

        return nonDuplicateStringBuilder.toString();
    }

    public String simplifiedRemoveDuplicateLetters(String string) {
        LinkedHashSet<Character> orderedUniqueSet = new LinkedHashSet<>();

        for (int j = 0; j < string.length(); j++) {
            orderedUniqueSet.add(string.charAt(j));
        }

        AtomicReference<String> uniqueString = new AtomicReference<>("");
        orderedUniqueSet.forEach(value -> uniqueString.updateAndGet(v -> v + value));

        return uniqueString.get();
    }



    // given a string, remove 3 or more consecutive same characters
    // whenever possible and return the final string
    // "aabbbbaccd" ⇒ “ccd”
    public String removeConsecutiveAdjacentCharacters(String string) {
        if (string.length() < 3) {
            return string;
        }

        Map<Character, Integer> letterTimesMap = new HashMap<>();
        boolean hasThreeLetters = false;
        char prev = '0';
        int i = 0;

        while (i < string.length()) {
            char currentChar = string.charAt(i);
            int times = letterTimesMap.get(currentChar) == null ? 1 : letterTimesMap.get(currentChar) + 1;

            if (hasThreeLetters && prev != currentChar) {
                string = string.replace(string.substring(i - letterTimesMap.get(prev), i), "");
                hasThreeLetters = false;

                if (string.isEmpty()) {
                    return string;
                }

                int lastIndex = string.lastIndexOf(currentChar);
                i = lastIndex == string.length() - 1 ? i - letterTimesMap.get(prev) : lastIndex; //TODO beeebb

                letterTimesMap.remove(prev);
            }

            if (times >= 3 && i == string.length() - 1) {
                int beginIndex = Math.max(i - times, 0);
                string = string.replace(string.substring(beginIndex, i + 1), "");
                return string;
            }

            if (letterTimesMap.containsKey(currentChar)) {
                if (times == 3) {
                    hasThreeLetters = true;
                    prev = currentChar;
                }

                letterTimesMap.put(currentChar, times);
            } else {
                letterTimesMap.putIfAbsent(currentChar, times);
            }

            i++;
        }

        return string;
    }
}
