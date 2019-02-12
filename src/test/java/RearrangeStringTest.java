import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RearrangeStringTest {

    private RearrangeString test = new RearrangeString();

    @Test
    public void rearrangeAString() {
        String s = "pineapple is cool";
        String target = "pppeelliioo  acns";

        assertThat(test.rearrangeAString(s)).isEqualTo(target);
    }
}