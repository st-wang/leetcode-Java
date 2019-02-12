public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Add two numbers saved in LinkedLists:
    // ex: list1 = [1, 3, 4]
    //     list2 = [2, 7, 1]
    //     result = [4, 0, 5]
    ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int sizeList1 = getSize(l1);
        int sizeList2 = getSize(l2);
        int miniSize = Math.min(sizeList1, sizeList2);
        ListNode l3 = new ListNode(0);
        int carry = 0;

        for (int i = 0; i < miniSize; i++){
            l3.next = new ListNode(l1.next.val + l2.next.val - 10 + carry);
            carry = l1.next.val + l2.next.val > 10 ? 1 : 0;
        }

        ListNode longerList = findLongerList(l1, l2);

        for (int i = miniSize; i < getSize(longerList); i++){
            l3.next = new ListNode(longerList.next.val + carry);
            carry = longerList.next.val + carry > 10 ? 1 : 0;
        }

        return l3;
    }

    private ListNode findLongerList(ListNode l1, ListNode l2){
        return getSize(l1) > getSize(l2) ? l1 : l2;
    }

    private int getSize(ListNode list){
        int size = 0;

        while (list.next != null){
            list = list.next;
            size++;
        }

        return size;
    }
}


