import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListOperationsTest {

    LinkedListOperations testInstance = new LinkedListOperations();

    @Test
    public void get_linkedList_values() {
        LinkedList list = createLinkedList(4);

        List<Integer> values = testInstance.getLinkedListValues(list);

        assertThat(values).isEqualTo(Arrays.asList(0, 1, 2, 3));
    }

    @Test
    public void reverse_linkedList() {
        LinkedList list = createLinkedList(4);

        LinkedList reversed = testInstance.reverseLinkedList(list);
        List<Integer> values = testInstance.getLinkedListValues(reversed);

        assertThat(values).isEqualTo(Arrays.asList(3, 2, 1, 0));
    }

    @Test
    public void return_Nth_node_from_the_end_of_linkedList() {
        LinkedList list = createLinkedList(6);

        LinkedList.LinkedNode node = testInstance.returnNthNodeInListFromEndWithStack(list.head, 4);

        assertThat(node.value).isEqualTo(2);
    }

    @Test
    public void remove_Nth_node_from_the_end_of_linkedList() {
        LinkedList list = createLinkedList(6);

        LinkedList.LinkedNode node = testInstance.removeNthNodeInListFromEnd(list.head, 4);

        assertThat(node.value).isEqualTo(0);
        assertThat(node.next.value).isEqualTo(1);
        assertThat(node.next.next.value).isEqualTo(3);
        assertThat(node.next.next.next.value).isEqualTo(4);
        assertThat(node.next.next.next.next.value).isEqualTo(5);
    }


    private LinkedList createLinkedList(int size) {
        LinkedList list = new LinkedList();
        list.head = new LinkedList.LinkedNode(0);
        LinkedList.LinkedNode node = list.head;

        for (int i = 1; i < size; i++) {
            node.next = new LinkedList.LinkedNode(i);
            node = node.next;
        }

        return list;
    }
}
