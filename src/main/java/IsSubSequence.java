
public class IsSubSequence {
    /*
        s = "abc",
        t = "ahbgdc",
        Return true.
    */

    public boolean isSubsequence(String sub, String string) { // O(m * n)
        int lengthString = string.length();
        int lengthSub = sub.length();

        if (lengthSub > lengthString || lengthSub == 0) {
            return false;
        }

        int j = 0;
        int i = 0;

        while (j < lengthSub && i < lengthString) {
            if (sub.charAt(j) == string.charAt(i)) {
                j++;
            }
            i++;
        }

        return j == lengthSub;
    }

}
