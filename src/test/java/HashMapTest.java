import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HashMapTest {

    @Test
    public void test() {
        HashMap map = new HashMap();

        map.put(1, 1);
        assertThat(map.get(1)).isEqualTo(1);
        assertThat(map.get(2)).isEqualTo(-1);
        map.put(2, 2);
        assertThat(map.get(2)).isEqualTo(2);
        map.remove(2);
        assertThat(map.get(2)).isEqualTo(-1);
        assertThat(map.get(1)).isEqualTo(1);
    }
}