import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MergeTwoListsTest {

    private MergeTwoLists test = new MergeTwoLists();

    @Test
    public void mergeTwoSortedLists() {
        List<Integer> list1 = asList(1, 3, 5, 6, 7);
        List<Integer> list2 = asList(1, 4, 8, 9, 10);
        List<Integer> expected = asList(1, 1, 3, 4, 5, 6, 7, 8, 9, 10);

        assertThat(test.mergeTwoSortedLists(list1, list2)).isEqualTo(expected);

        // TEST
//        LinkedList<Integer> linkedList1 = new LinkedList<>(asList(1, 5, 6));
//
//        LinkedList<Integer> linkedList2 = new LinkedList<>();
//        linkedList2.add(1);
//        linkedList2.add(5);
//        linkedList2.offer(6);
//
//        LinkedList<Integer> linkedList3 = new LinkedList<>();
//        linkedList3 = linkedList2;
//        linkedList3.offerLast(6);
//
//        assertThat(linkedList1).isEqualTo(linkedList2);
//        assertThat(linkedList1).isEqualTo(linkedList3);
    }

    @Test
    public void mergeTwoSortedLists2() {
        List<Integer> list1 = asList(2, 6, 7);
        List<Integer> list2 = asList(1, 4, 8, 9, 10);
        List<Integer> expected = asList(1, 2, 4, 6, 7, 8, 9, 10);

        assertThat(test.mergeTwoSortedLists(list1, list2)).isEqualTo(expected);
    }
}