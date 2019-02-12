import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecursionTest {

    private Recursion recursionTest = new Recursion();
    private String s = "abc";

    @Test
    public void permutationTest() {
        assertThat(recursionTest.permutation(s)) //
                .containsExactlyInAnyOrder("abc", "acb", "bca", "bac", "cab", "cba");
    }

    @Test
    public void combinationTest() {
        assertThat(recursionTest.combination(s)) //
                .containsExactlyInAnyOrder("abc", "ab", "bc", "ac", "a", "b", "c", "");
    }

    @Test
    public void reverseStringRecursionTest() {
        assertThat(recursionTest.reverseStringRecursion(s)).isEqualTo("cba");
    }
}