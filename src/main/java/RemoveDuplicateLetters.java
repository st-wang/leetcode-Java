import java.util.HashSet;

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

    // given a string, remove 3 or more consecutive same characters whenever possible
    // and return the final string
    // "aabbbbaccd" ⇒ “ccd”
    public String removeConsecutiveAdjacentCharacters(String string) {
        if (string.length() < 3) {
            return string;
        }

        return null;
    }
}
