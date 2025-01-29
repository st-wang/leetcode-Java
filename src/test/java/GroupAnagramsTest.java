import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;


public class GroupAnagramsTest {

    @Test
    public void groupAnagrams() {
        GroupAnagrams test = new GroupAnagrams();

        String[] strs = {"act","pots","tops","cat","stop","hat"};

        List<List<String>> anagrams = test.groupAnagrams(strs);

        anagrams.stream().forEach(System.out::println);
    }
}