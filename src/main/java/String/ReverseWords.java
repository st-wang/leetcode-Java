package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWords {
    //Given an input string s, reverse the order of the words.
    //A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
    //Return a string of the words in reverse order concatenated by a single space.
    //
    //Note that s may contain leading or trailing spaces or multiple spaces between two words.
    //The returned string should only have a single space separating the words. Do not include any extra spaces.
    //
    //Example 1:
    //Input: s = "the sky is blue"
    //Output: "blue is sky the"
    //
    //Example 2:
    //Input: s = "  hello world  "
    //Output: "world hello"
    //Explanation: Your reversed string should not contain leading or trailing spaces.
    //
    //Example 3:
    //Input: s = "a good   example"
    //Output: "example good a"
    //Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

    //Constraints:
    //
    //1 <= s.length <= 10^4
    //s contains English letters (upper-case and lower-case), digits, and spaces ' '.
    //There is at least one word in s.

    public String reverseWords(String s) {
        s = s.replaceAll("^\\s+|\\s+$", "").replaceAll("\\s{2,}", " ");

        if (!s.contains(" ")) {
            return s;
        }

        List<String> list = new ArrayList<>(Arrays.stream(s.trim().split("\\s")).toList());

        int index = list.size() / 2;

        for (int i = 0; i < index; i++) {
            String temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }

        return String.join(" ", list);
    }

    /// ///// Follow-up: resolve in 0(1) extra space
    public String reverseWords_O1Space(String s) {
        s = s.replaceAll("^\\s+|\\s+$", "").replaceAll("\\s{2,}", " ");

        if (!s.contains(" ")) {
            return s;
        }
        int firstSpace = s.indexOf(" ");
        int lastSpace = s.lastIndexOf(" ");
        int initialLength = s.length();

        String half1 = "";
        String half2 = "";

        while (firstSpace <= lastSpace) {
            half2 = " " + s.substring(0, firstSpace) + half2;
            half1 += s.substring(lastSpace + 1) + " ";

            if (firstSpace != lastSpace) {
                s = s.substring(firstSpace + 1, lastSpace);
            } else { // there is only one space, the parsing is over
                s = "";
                firstSpace = initialLength; // to get out of the loop
            }
            if (!s.isEmpty()) {
                if (s.contains(" ")) {
                    firstSpace = s.indexOf(" ");
                    lastSpace = s.lastIndexOf(" ");
                } else { //one word left
                    half1 += s + " ";
                    firstSpace = initialLength; // to get out of the loop
                }
            }
        }

        return (half1 + half2).replaceAll("\\s{2,}", " ");
    }

    public String reverseWords_best(String s) {
        String[] words = s.trim().split(" +");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.append(words[0]); // to not append an extra " " in the end

        return stringBuilder.toString();
    }
}
