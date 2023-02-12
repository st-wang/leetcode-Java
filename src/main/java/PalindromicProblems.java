import java.util.HashMap;
import java.util.Map;

public class PalindromicProblems {

    // Palindromic strings => abc - cba
    // Case ignored
    boolean isPalindromicPermutation(String a, String b) {
        if (a.equals("") && b.equals("")) {
            return true;
        }

        if (a.length() != b.length()) {
            return false;
        }

        int length = a.length();
        a = a.toLowerCase();
        b = b.toLowerCase();

        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }

    // Palindromic string => abb a
    // Blanks ignored
    // Case ignored
    boolean isPalindromicString(String a) {
        if (a.equals("")) {
            return true;
        }

        String string = a.toLowerCase();
        string = string.replaceAll(" ", "");
        int length = string.length();

        for (int i = 0; i <= length / 2; i++) {
            if (string.charAt(i) != string.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    // For aab,
    // Substrings are a, a, b, aa, ab, ab
    // Among which the palindromic ones are a, a, b, aa
    public int palindromicSubstrings(String inputString) {
        if (inputString == null) {
            return 0;
        }

        if (inputString.equals("")) {
            return 1;
        }

        int substringCount = inputString.length();
        String currentSubstring;
        int inputStringLength = inputString.length();
        for (int j = 0; j < inputStringLength - 1; j++) {
            for (int i = j + 1; i < inputStringLength; i++) {
                currentSubstring = inputString.substring(j, i + 1);

                if (isPalindromicString(currentSubstring)) {
                    substringCount++;
                }
            }
        }

        return substringCount;
    }

    /*Example:
      Input: "bbbab"
      Output: 4
      One possible longest palindromic subsequence is "bbbb".
    */
    public int longestPalindromicSubsequence(String s) {
        if (s == null) {
            return 0;
        }

        if (s.equals("")) {
            return 1;
        }

        int longestSubsequence = 0;


        return longestSubsequence;
    }

    /* Example:
       Input: "abccccdd"
       Output: 7
       Explanation:
       One longest palindrome that can be built is "dccaccd" or "dccbccd", whose length is 7.
       "Aa" is not a palindrome.
    */
    public int longestPalindrome(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) { // build letter frequency map
            char currentChar = s.charAt(i);
            if (frequencyMap.containsKey(currentChar)) {
                int frequency = frequencyMap.get(currentChar);
                frequencyMap.put(currentChar, frequency + 1);
            } else {
                frequencyMap.put(currentChar, 1);
            }
        }

        boolean hasAnOddCharacter = false;
        int longestPalindrome = 0;

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            int freq = entry.getValue();

            if (freq % 2 != 0) {
                hasAnOddCharacter = true;
                longestPalindrome += freq - 1;
            } else {
                longestPalindrome += freq;
            }
        }

        if (hasAnOddCharacter) {
            return longestPalindrome + 1;
        } else {
            return longestPalindrome;
        }
    }

    /*Find the smallest prime palindrome greater than or equal to N.
      Examples:
      Input: 6
      Output: 7

      Input: 8
      Output: 11

      Input: 13
      Output: 101

      Note:
      1 <= N <= 10^8
      The answer is guaranteed to exist and be less than 2 * 10^8.
    */
    public int primePalindrome(int N) {
        if (N == 1) {
            return N + 1;
        }

        while (!IsPrime.isANumberPrime(N) || !isANumberPalindrome(N)) {
            N = N + 1;
        }
        return N;
    }

    public boolean isANumberPalindrome(int number) {
//        String numberString = String.valueOf(number);
//
//        for (int i = 0; i < numberString.length(); i++) {
//            if (numberString.charAt(i) != numberString.charAt(numberString.length() - i - 1)) {
//                return false;
//            }
//        }

        return isPalindromicString(String.valueOf(number));
    }
}
