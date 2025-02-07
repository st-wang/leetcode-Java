package String;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class URLifyTest {
    private URLify testInstance = new URLify();

    @Test
    public void can_urlify_a_string() {
        String a = "hey you     ";
        String res = testInstance.urlifyAString(a);

        assertThat(res).isEqualTo("hey%20you");
    }

    @Test
    public void can_urlify_a_string2() {
        String a = "hey       you       ";
        String res = testInstance.urlifyAString(a);

        assertThat(res).isEqualTo("hey%20you");
    }
}
