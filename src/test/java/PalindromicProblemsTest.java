import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PalindromicProblemsTest {
    private final PalindromicProblems testInstance = new PalindromicProblems();

    @Test
    public void testPalindromicPermutation_1() {
        String a = "abc";
        String b = "cba";

        assertThat(testInstance.isPalindromicPermutation(a, b)).isTrue();
    }

    @Test
    public void testPalindromicPermutation_2() {
        String a = "abc";
        String b = "cab";

        assertThat(testInstance.isPalindromicPermutation(a, b)).isFalse();
    }

    @Test
    public void testPalindromicPermutation_3() {
        String a = "Abc ad";
        String b = "da cab";

        assertThat(testInstance.isPalindromicPermutation(a, b)).isFalse();
    }

    @Test
    public void testPalindromicPermutation_4() {
        String a = "Taco Cat";

        assertThat(testInstance.isPalindromicString(a)).isTrue();
    }

    @Test
    public void testPalindromicSubstrings_1() {
        String a = "abc";

        assertThat(testInstance.palindromicSubstrings(a)).isEqualTo(3);
    }

    @Test
    public void testPalindromicSubstrings_2() {
        String a = "aaa";

        assertThat(testInstance.palindromicSubstrings(a)).isEqualTo(6);
    }

    @Test
    public void longestPalindrome() {
        String s = "aa"; //"aa"

        assertThat(testInstance.longestPalindrome(s)).isEqualTo(2);
    }

    @Test
    public void longestPalindrome_1() {
        String s = "abccccdd"; //"ccdbdcc"

        assertThat(testInstance.longestPalindrome(s)).isEqualTo(7);
    }

    @Test
    public void longestPalindrome_2() {
        String s = "Aaccbbbdd"; // "cdbbbdc"

        assertThat(testInstance.longestPalindrome(s)).isEqualTo(7);
    }

    @Test
    public void longestPalindrome_3() {
        String s = "AAAAAccbbbdd"; // "cdbAAAAAbdc"

        assertThat(testInstance.longestPalindrome(s)).isEqualTo(11);
    }

    @Test
    public void longestPalindrome_4() {
        String s = "AAAAAccbbbddeee"; // "cdbeAAAAAebdc"

        assertThat(testInstance.longestPalindrome(s)).isEqualTo(13);
    }

    @Test
    public void longestPalindrome_5() {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"; // "cdAAAAAdc"

        assertThat(testInstance.longestPalindrome(s)).isEqualTo(983);
    }

    @Test
    public void isANumberPalindrome() {
        int n = 12321;

        assertThat(testInstance.isANumberPalindrome(n)).isTrue();
    }

    @Test
    public void isANumberPalindrome_2() {
        int n = 12;

        assertThat(testInstance.isANumberPalindrome(n)).isFalse();
    }

    @Test
    public void primePalindrome() {
        int n = 13;

        assertThat(testInstance.primePalindrome(n)).isEqualTo(101);
    }

    @Test
    public void primePalindrome_2() {
        int n = 102;

        assertThat(testInstance.primePalindrome(n)).isEqualTo(131);
    }

    @Test
    public void primePalindrome_3() {
        int n = 2;

        assertThat(testInstance.primePalindrome(n)).isEqualTo(2);
    }

    @Test
    public void primePalindrome_4() {
        int n = 1;

        assertThat(testInstance.primePalindrome(n)).isEqualTo(2);
    }

    @Test
    public void primePalindrome_5() {
        int n = 9989900;

        assertThat(testInstance.primePalindrome(n)).isEqualTo(2);
    }

}