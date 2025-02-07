package String;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    //Design an algorithm to encode a list of strings to a single string.
    //The encoded string is then decoded back to the original list of strings.
    //
    //Please implement encode and decode
    //
    //Example 1:
    //Input: ["neet","code","love","you"]
    //Output:["neet","code","love","you"]
    //
    //Example 2:
    //Input: ["we","say",":","yes"]
    //Output: ["we","say",":","yes"]
    //
    //Constraints:
    //0 <= strs.length < 100
    //0 <= strs[i].length < 200
    //strs[i] contains only UTF-8 characters.

    // You should aim for a solution with O(m) time and O(1) space for each encode() and decode() call,
    // where m is the sum of lengths of all the strings.

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";

        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        String subStr = str;
        List<String> strs = new ArrayList<>();

        while (i < str.length()) {
            int delimiter_pos = subStr.indexOf('#');
            int length = Integer.parseInt(subStr.substring(0, delimiter_pos));
            strs.add(subStr.substring(delimiter_pos + 1, delimiter_pos + 1 + length));
            i += delimiter_pos + 1 + length;
            subStr = str.substring(i);
        }
        return strs;

    }
}
