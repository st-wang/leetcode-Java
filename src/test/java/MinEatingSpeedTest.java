import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MinEatingSpeedTest {
    private MinEatingSpeed test = new MinEatingSpeed();

    @Test
    public void minEatingSpeed() {
        int[] piles = {1, 4, 3, 2};
        int h = 9;

        assertThat(test.minEatingSpeed(piles, h)).isEqualTo(2);
    }

    @Test
    public void minEatingSpeed_2() {
        int[] piles = {25, 10, 23, 4};
        int h = 4;

        assertThat(test.minEatingSpeed(piles, h)).isEqualTo(25);
    }
}