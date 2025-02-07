package String;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EncodeDecodeStringsTest {

    @Test
    public void test_encode() {
        EncodeDecodeStrings test = new EncodeDecodeStrings();
        List<String> strs = Arrays.asList("we", "say", ":", "ok", "!@#$%^&*()");
//        List<String> strsss = List.of("we", "say", ":", "ok");

        String encoded = test.encode(strs);
        assertThat(encoded).isEqualTo("2#we3#say1#:2#ok10#!@#$%^&*()");
    }

    @Test
    public void test_decode() {
        EncodeDecodeStrings test = new EncodeDecodeStrings();
        List<String> strs = Arrays.asList("we", "say", ":", "ok", "!@#$%^&*()");
        String str = "2#we3#say1#:2#ok10#!@#$%^&*()";

        List<String> decoded = test.decode(str);
        assertThat(decoded).isEqualTo(strs);
    }
}
