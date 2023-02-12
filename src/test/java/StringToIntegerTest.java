import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringToIntegerTest {

    private final StringToInteger testInstance = new StringToInteger();

    @Test
    public void test_atoi_1() {
        String s = "  -42";
        assertThat(testInstance.myAtoi(s)).isEqualTo(-42);
    }

    @Test
    public void test_atoi_2() {
        String s = "42 iop";
        assertThat(testInstance.myAtoi(s)).isEqualTo(42);
    }

    @Test
    public void test_atoi_3() {
        String s = "iop 42";
        assertThat(testInstance.myAtoi(s)).isEqualTo(0);
    }
}