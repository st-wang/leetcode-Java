package BBLeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrappingRainWaterTest {

    @Test
    public void calculateTrappedWater() {
        TrappingRainWater waterTrapper = new TrappingRainWater();
        List<Integer> elevationMap = new ArrayList<>(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1));

        assertThat(waterTrapper.calculateTrappedWater(elevationMap)).isEqualTo(6);
    }
}