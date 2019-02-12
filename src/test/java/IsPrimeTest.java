import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsPrimeTest {

    @Test
    public void isANumberPrime() {
        assertThat(IsPrime.isANumberPrime(233)).isTrue();
    }

    @Test
    public void isANumberPrime_2() {
        assertThat(IsPrime.isANumberPrime(121)).isFalse();
    }

    @Test
    public void smallestPrime() {
        IsPrime test = new IsPrime();

        assertThat(test.smallestPrime(230)).isEqualTo(233);
    }
}