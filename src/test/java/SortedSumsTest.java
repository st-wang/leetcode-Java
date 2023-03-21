import org.junit.Test;

import java.text.DecimalFormat;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class SortedSumsTest {
    SortedSums test = new SortedSums();

    @Test
    public void sum() {
        List<Integer> a = asList(3, 9, 5, 8);

        assertThat(test.sortedSum(a)).isEqualTo(80);
    }

    @Test
    public void sum_2() {
        List<Integer> a = asList(2, 7, 5);
        String s = "123";
        System.out.println(Integer.parseInt());
//        assertThat(test.sortedSum(a)).isEqualTo(26);
    }

    @Test
    public void other() {
        float f = (float)1/(float)6;

        DecimalFormat decimalFormat = new DecimalFormat("#.######");
        System.out.println(decimalFormat.format(f));
        System.out.printf("%.6f", f);
    }
}