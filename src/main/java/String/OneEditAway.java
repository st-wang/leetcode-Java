package String;

import static java.lang.Math.*;

public class OneEditAway {

    public boolean oneEdit (String s1, String s2) {
        int lengthS1 = s1.length();
        int lengthS2 = s2.length();

        if (abs(lengthS1 - lengthS2) > 1) {
            return false;
        }

        if (lengthS1 == lengthS2) {
            return hasReplacement(s1, s2) == 1;
        } else if (lengthS1 > lengthS2) {
            //return (s1, s2) == 0;
        } else {
            // return (s2, s1) == 0;
        }
        return true;
    }

    private int hasReplacement(String s1, String s2) {
        int diffs = 0;

        for (int i = 0; i < s2.length(); i++) {
            diffs = s1.charAt(i) != s2.charAt(i) ? diffs + 1 : diffs;
        }

        return diffs;
    }

}
