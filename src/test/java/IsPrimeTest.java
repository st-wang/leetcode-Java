import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsPrimeTest {

    @Test
    public void isANumberPrime() {
        assertThat(IsPrime.isANumberPrime(233)).isTrue();
        assertThat(IsPrime.isANumberPrime(121)).isFalse();
    }

    @Test
    public void isSmallestPrime() {
        IsPrime test = new IsPrime();

        assertThat(test.smallestPrime(230)).isEqualTo(233);
    }
}