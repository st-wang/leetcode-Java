import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueHistogramTest {

    @Test
    public void createHistogram() {
        ValueHistogram test = new ValueHistogram();

        double[] values = new double[]{0.5, 0.6, 0.7, 1.0, 2.0};
        double[] bounds = new double[]{0.8, 1.5};

        int[] expected = new int[]{3, 1, 1};

        assertThat(test.createHistogram(values, bounds)).isEqualTo(expected);
    }
}