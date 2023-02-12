import java.util.Stack;

public class Reverse {

    // Best DS for reverse : Stack !

    // s = ["h","e","l","l","o"] -> ["o","l","l","e","h"]
    // s = ["H","a","n","n","a","h"] -> ["h","a","n","n","a","H"]

    public void reverseString(char[] s) {
        int length = s.length;
        if (length == 1) return;

        int mid;
        if (length % 2 == 0) {
            mid = length / 2;
        } else {
            mid = length / 2 + 1;
        }

        for (int i = 0; i < mid; i++) {
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }

    }

    public void reverseString2(char[] s) {
        int length = s.length;
        if (length == 1) return;

        Stack<Character> stack = new Stack<>();

        for (char c : s) {
            stack.push(c);
        }

        for (int i = 0; i < length; i++) {
            s[i] = stack.pop();
        }

    }

    public int reverseInteger(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
