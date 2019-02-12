import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MultiplyTwoStringsTest {

    @Test
    public void multiply_two_strings() {
        MultiplyTwoStrings testClass = new MultiplyTwoStrings();

        String testString = "401716832807512840963";
        String testString2 = "167141802233061013023557397451289113296441069";

        assertThat(testClass.multiply(testString, testString2))
                .isEqualTo("67143675422804947379429215144664313370120390398055713625298709447");
    }

}