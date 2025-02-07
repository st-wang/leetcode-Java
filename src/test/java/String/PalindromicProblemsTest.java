package String;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class PalindromicProblemsTest {
    private final PalindromicProblems testInstance = new PalindromicProblems();

    @Test
    public void testPalindromicPermutation_1() {
        String a = "abc";
        String b = "cba";

        Assertions.assertThat(testInstance.isPalindromicPermutation(a, b)).isTrue();
    }

    @Test
    public void testPalindromicPermutation_2() {
        String a = "abc";
        String b = "cab";

        Assertions.assertThat(testInstance.isPalindromicPermutation(a, b)).isFalse();
    }

    @Test
    public void testPalindromicPermutation_3() {
        String a = "Abc ad";
        String b = "da cab";

        Assertions.assertThat(testInstance.isPalindromicPermutation(a, b)).isFalse();
    }

    @Test
    public void testPalindromicString() {
        String a = "Taco Cat";

        Assertions.assertThat(testInstance.isPalindromicString(a)).isTrue();
    }

    @Test
    public void testPalindromicString2() {
        String a = "Taco Cat";

        Assertions.assertThat(testInstance.isPalindromicString2(a)).isTrue();
    }

    @Test
    public void testPalindromicString2_2() {
        String a = "ta ro o?rat)";

        Assertions.assertThat(testInstance.isPalindromicString2(a)).isTrue();
    }

    @Test
    public void testPalindromicSubstrings_1() {
        String a = "abc";

        Assertions.assertThat(testInstance.palindromicSubstrings(a)).isEqualTo(3);
    }

    @Test
    public void testPalindromicSubstrings_2() {
        String a = "aaa";

        Assertions.assertThat(testInstance.palindromicSubstrings(a)).isEqualTo(6);
    }

    @Test
    public void longestPalindrome() {
        String s = "aa"; //"aa"

        Assertions.assertThat(testInstance.longestPalindrome(s)).isEqualTo(2);
    }

    @Test
    public void longestPalindrome_1() {
        String s = "abccccdd"; //"ccdbdcc"

        Assertions.assertThat(testInstance.longestPalindrome(s)).isEqualTo(7);
    }

    @Test
    public void longestPalindrome_2() {
        String s = "Aaccbbbdd"; // "cdbbbdc"

        Assertions.assertThat(testInstance.longestPalindrome(s)).isEqualTo(7);
    }

    @Test
    public void longestPalindrome_3() {
        String s = "AAAAAccbbbdd"; // "cdbAAAAAbdc"

        Assertions.assertThat(testInstance.longestPalindrome(s)).isEqualTo(11);
    }

    @Test
    public void longestPalindrome_4() {
        String s = "AAAAAccbbbddeee"; // "cdbeAAAAAebdc"

        Assertions.assertThat(testInstance.longestPalindrome(s)).isEqualTo(13);
    }

    @Test
    public void longestPalindrome_5() {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"; // "cdAAAAAdc"

        Assertions.assertThat(testInstance.longestPalindrome(s)).isEqualTo(983);
    }

    @Test
    public void test_generate_subSequence() {
        String s = "bbab";

        Assertions.assertThat(PalindromicProblems.generateSubsequences(s)).isEqualTo(Arrays.asList("b", "b", "a", "b"));
    }

    @Test
    public void isANumberPalindrome() {
        int n = 12321;

        Assertions.assertThat(testInstance.isANumberPalindrome(n)).isTrue();
    }

    @Test
    public void isANumberPalindrome_2() {
        int n = 12;

        Assertions.assertThat(testInstance.isANumberPalindrome(n)).isFalse();
    }

    @Test
    public void primePalindrome() {
        int n = 13;

        Assertions.assertThat(testInstance.primePalindrome(n)).isEqualTo(101);
    }

    @Test
    public void primePalindrome_2() {
        int n = 102;

        Assertions.assertThat(testInstance.primePalindrome(n)).isEqualTo(131);
    }

    @Test
    public void primePalindrome_3() {
        int n = 2;

        Assertions.assertThat(testInstance.primePalindrome(n)).isEqualTo(2);
    }

    @Test
    public void primePalindrome_4() {
        int n = 1;

        Assertions.assertThat(testInstance.primePalindrome(n)).isEqualTo(2);
    }

    @Test
    public void primePalindrome_5() {
        int n = 9989900;

        Assertions.assertThat(testInstance.primePalindrome(n)).isEqualTo(2);
    }

}