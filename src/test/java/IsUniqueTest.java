import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class IsUniqueTest {
    private final IsUnique testInstance = new IsUnique();

    @Test
    public void unique_test() {
        String a = "abc";

        assertThat(testInstance.isStringUnique(a)).isTrue();
    }

    @Test
    public void unique_test_2() {
        String a = "abcab";

        assertThat(testInstance.isStringUnique(a)).isFalse();
    }

    @Test
    public void unique_test_without_extra_space() {
        String a = "abc";
        String b = "abcab";
        String c = "a bc";

        assertThat(testInstance.isStringUniqueWithoutExtraSpace(a)).isTrue();
        assertThat(testInstance.isStringUniqueWithoutExtraSpace(b)).isFalse();
        assertThat(testInstance.isStringUniqueWithoutExtraSpace(c)).isFalse(); // Not sure about the expected result
    }
}