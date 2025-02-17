package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseVowels {

    //Given a string s, reverse only all the vowels in the string and return it.
    //The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
    //
    //Example 1:
    //Input: s = "IceCreAm"
    //Output: "AceCreIm"
    //Explanation:
    //The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
    //
    //Example 2:
    //Input: s = "leetcode"
    //Output: "leotcede"
    //
    //Constraints:
    //1 <= s.length <= 3 * 105
    //s consist of printable ASCII characters.

    public String reverseVowels(String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        List<String> temp = new ArrayList<>(Arrays.stream((s.trim().split(""))).toList());

        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!vowels.contains(s.charAt(i))) {
                i++;
            } else if (!vowels.contains(s.charAt(j))) {
                j--;
            } else {
                String tempS = String.valueOf(s.charAt(i));
                temp.set(i, String.valueOf(s.charAt(j)));
                temp.set(j, tempS);
                i++;
                j--;
            }
        }

        return String.join("", temp);
    }
}
