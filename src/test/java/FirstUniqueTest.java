import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstUniqueTest {

    private final FirstUnique testInstance = new FirstUnique();

    @Test
    public void findFirstUniqueNumberTest() {
        List<Integer> list = new ArrayList<>(asList(2, 7, 1, 6, 2, 5, 6));

        assertThat(testInstance.findFirstUniqueNumber(list)).isEqualTo(7);
    }

    @Test
    public void findFirstUniqueCharTest() {
        String s1 = "tomato";
        String s2 = " tomato";

        assertThat(testInstance.findFirstUniqueCharacter(s1)).isEqualTo('m');
        assertThat(testInstance.findFirstUniqueCharacter(s2)).isEqualTo(' ');
    }
}