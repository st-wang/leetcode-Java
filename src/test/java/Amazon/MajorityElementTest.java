package Amazon;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MajorityElementTest {

    @Test
    public void findMajorityElement() {
        List<Integer> array = Arrays.asList(3, 2, 2, 2, 3, 3, 2);

        assertThat((new MajorityElement()).findMajorityElement(array)).isEqualTo(2);
    }

    @Test
    public void findMajorityElement2() {
        List<Integer> array = Arrays.asList(3, 2, 2, 3, 3, 2);

        assertThat((new MajorityElement()).findMajorityElement(array)).isEqualTo(-1);
    }
}