/*
 s = "abc", t = "ahbgdc"
 Return true.
*/
public class IsSubSequence {
    public boolean isSubsequence (String s, String t) {
        int lengthT = t.length();
        int lengthS = s.length();

        if (lengthS > lengthT) {
            return false;
        }

        String charsInT = "";

        for (int i = 0; i < lengthT; i++) {
            charsInT = charsInT + String.valueOf(t.charAt(i) - 'a');
        }
        return false;
    }

}
