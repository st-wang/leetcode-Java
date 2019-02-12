import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddTwoNumbersTest {

    @Test
    public void can_add_two_numbers() {
        AddTwoNumbers addTwoNumbersClass = new AddTwoNumbers();
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(0);
        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(0);

        AddTwoNumbers.ListNode result = addTwoNumbersClass.addTwoNumbers(l1, l2);

        assertThat(result.next).isNotNull();
    }

}