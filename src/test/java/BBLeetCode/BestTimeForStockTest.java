package BBLeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BestTimeForStockTest {
    BestTimeForStock testInstance = new BestTimeForStock();
    List<Integer> priceList = Arrays.asList(7, 1, 5, 2, 6, 4);

    @Test
    public void maxProfitOneTransaction() {
        int expected = 5;

        assertThat(testInstance.maxProfitOneTransaction(priceList)).isEqualTo(expected);
    }
}