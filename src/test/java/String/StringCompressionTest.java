package String;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCompressionTest {
    private StringCompression test = new StringCompression();

    @Test
    public void compress_listSolution() {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c'};

        assertThat(test.compress_listSolution(chars)).isEqualTo(6);
    }

    @Test
    public void compress_solution() {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c'};

        assertThat(test.compress_lessExtraSpaceSolution(chars)).isEqualTo(6);
    }

    @Test
    public void compress_returnChars() {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c'};

        assertThat(test.compress_returnCompressedString(chars)).isEqualTo(new char[]{'a', 'b', '1', '1', 'c', '2'});
    }
}