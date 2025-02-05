import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class KeyValueStoreTest {
    private KeyValueStore test = new KeyValueStore();

    @Test
    public void can_do_map_operations() {
        KeyValueStore.TimeMap timeMap = new KeyValueStore.TimeMap();

        timeMap.set("alice", "happy", 1);
        assertThat(timeMap.get("alice", 1)).isEqualTo("happy");
        assertThat(timeMap.get("alice", 2)).isEqualTo("happy");

        timeMap.set("alice", "sad", 3);
        assertThat(timeMap.get("alice", 3)).isEqualTo("sad");

        timeMap.set("key1", "value1", 10);
        assertThat(timeMap.get("key1", 1)).isEmpty();
        assertThat(timeMap.get("key1", 10)).isEqualTo("value1");
        assertThat(timeMap.get("key1", 11)).isEqualTo("value1");
    }
}