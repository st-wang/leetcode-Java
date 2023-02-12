public class LinkedList {

    // Definition for singly-linked list
    LinkedNode head;

    static class LinkedNode {
        int value;
        LinkedNode next;

        public LinkedNode(int v) {
            this.value = v;
            this.next = null;
        }
    }
}
