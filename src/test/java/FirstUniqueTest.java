import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstUniqueTest {

    private FirstUnique testInstance = new FirstUnique();

    @Test
    public void findFirstUniqueNumberTest() {
        List<Integer> list = new ArrayList<>(asList(2, 5, 6, 2, 1, 6));

        assertThat(testInstance.findFirstUniqueNumber(list)).isEqualTo(5);
    }

    @Test
    public void findFirstUniqueCharTest() {
        String s = "tomato";

        assertThat(testInstance.findFirstUniqueCharacter(s)).isEqualTo('m');
    }

    @Test
    public void findFirstUniqueCharTest_2() {
        String s = " tomato";

        assertThat(testInstance.findFirstUniqueCharacter(s)).isEqualTo(' ');
    }
}