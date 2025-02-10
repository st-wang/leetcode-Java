package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCompression {
    //Given an array of characters chars, compress it using the following algorithm:
    //
    //Begin with an empty string s. For each group of consecutive repeating characters in chars:
    //If the group's length is 1, append the character to s.
    //Otherwise, append the character followed by the group's length.
    //Note that group lengths that are 10 or longer will be split into multiple characters in chars.
    //After you are done modifying the input array, return the new length of the array.
    //
    //---------You must write an algorithm that uses only constant extra space---------//
    //
    //Example 1:
    //Input: chars = ["a","a","b","b","c","c","c"]
    //Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
    //Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
    //
    //Example 2:
    //Input: chars = ["a"]
    //Output: Return 1, and the first character of the input array should be: ["a"]
    //Explanation: The only group is "a", which remains uncompressed since it's a single character.
    //
    //Example 3:
    //Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
    //Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
    //Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
    //
    //Constraints:
    //1 <= chars.length <= 2000
    //chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.


    public int compress_listSolution(char[] chars) {
        int length = chars.length;
        if (length == 1) return 1;

        char current = chars[0];
        int freq = 1;
        List<Character> compressed = new ArrayList<>();

        for (int i = 1; i < length; i++) {
            if (chars[i] == current) {
                freq++;
                if (i == length - 1) {
                    compressed.add(current);
                    System.out.println(compressed);
                    if (freq != 1) {
                        int count = String.valueOf(freq).length();
                        for (int j = 1; j < count; j++) {
                            compressed.add((char) j);
                        }
                    }
                }
            } else {
                compressed.add(current);
                System.out.println(compressed);

                if (freq != 1) {
                    int count = String.valueOf(freq).length();
                    for (int j = 1; j < count; j++) {
                        compressed.add((char) j);
                    }

                }
                freq = 1;
                current = chars[i];
            }
        }
        System.out.println(compressed);

        return compressed.size();
    }

    //////-------
    /// Next level:
    /// Save the compressed string in the input character array chars and return
    public char[] compress_returnCompressedString(char[] chars) {
        int length = chars.length;
        if (length == 1) return chars;

        String s = "";

        int index = 0;
        for (int i = 0; i < length; i++) {
            char current = chars[i];
            int count = 0;
            while (i < length && chars[i] == current) {  // double loop, double pointer
                count++;
                i++;
            }
            if (count == 1) {
                s += current;
                index++;
            } else {
                s += current;
                index++;
                for (char digit : Integer.toString(count).toCharArray()) {
                    s += digit;
                    index++;
                }
            }
            i--;
        }

        chars = s.toCharArray();
        return chars;
    }

    public int compress_lessExtraSpaceSolution(char[] chars) {
        int length = chars.length;
        if (length == 1) return 1;

        char current = chars[0];
        int freq = 1;
        int total = 0;

        for (int i = 1; i < length; i++) {
            if (chars[i] == current) {
                freq++;
                if (i == length - 1) {
                    total++;
                    if (freq != 1) {
                        total += String.valueOf(freq).length();
                    }
                }
            } else {
                total++;
                if (freq != 1) {
                    total += String.valueOf(freq).length();
                }
                freq = 1;
                current = chars[i];
            }
        }

        return total;
    }
}
