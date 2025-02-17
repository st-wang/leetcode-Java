package String;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ReverseVowelsTest {
    private  ReverseVowels test = new ReverseVowels();

    @Test
    public void reverseVowels() {
        String s = "IceCreAm";

        List<String> list = List.of("apple", "banana", "cherry");

        System.out.println(String.join("", list));

        assertThat(test.reverseVowels(s)).isEqualTo("AceCreIm");
    }
}