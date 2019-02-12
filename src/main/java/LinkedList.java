import java.util.HashMap;
import java.util.Stack;

public class LinkedList {

    int value;
    LinkedList next;

    public LinkedList() {
        this.next = null;
    }

    public LinkedList(int v) {
        this.value = v;
        this.next = null;
    }

    // single linked list, with a special variable "jump":
    // pointing to either null or whatever node within the list
    // write a deep copy for such a list (note: it can be done in O(n))
    class LinkedListWithJump {
        NormalNode head;

        LinkedListWithJump(NormalNode head) {
            this.head = head;
        }
    }

    class NormalNode {
        int value;
        NormalNode next = null;

        NormalNode() {
        }

        NormalNode(int value) {
            this.value = value;
        }
    }

    class JumpNode extends NormalNode {
        NormalNode jump = null;

        JumpNode() {
            super();
        }
    }

    public LinkedListWithJump deepCopySingleLinkedList(LinkedListWithJump origin) {
        LinkedListWithJump copy = new LinkedListWithJump(new NormalNode());

        NormalNode newHead = copy.head;
        NormalNode originHead = origin.head;
        //newHead = originHead;

        while (originHead.next != null) {
            if (originHead instanceof JumpNode) {

            }

            newHead.value = originHead.value;
            newHead.next = originHead.next;


        }

        return copy;
    }


    //----------------------------------------------------------------------//
    // You are given a Double Link List with one pointer of each node
    // pointing to the next node just like in a single link list.
    // The second pointer which is arbitary pointer which can point to
    // any node in the list and not just the previous node.
    // The task is to complete the function copyList which
    // takes one argument the head of the linked list to be copied
    // and should return the head of the copied linked list

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }


    public RandomListNode copyRandomList(RandomListNode head) {

        // HashMap which holds old nodes as keys and new nodes as its values.
        HashMap<RandomListNode, RandomListNode> visitedHash =
                new HashMap<RandomListNode, RandomListNode>();

        if (head == null) {
            return null;
        }

        // If we have already processed the current node, then we simply return the cloned version of it.
        if (visitedHash.containsKey(head)) {
            return visitedHash.get(head);
        }

        // Create a new node with the label same as old node. (i.e. copy the node)
        RandomListNode copyNode = new RandomListNode(head.label);

        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid them.
        visitedHash.put(head, copyNode);

        // Recursively copy the remaining linked list starting once from the next pointer and then from the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        copyNode.next = copyRandomList(head.next);
        copyNode.random = copyRandomList(head.random);

        return copyNode;
    }

    // return the Nth node in a LinkedList
    // case 1: with known LinkedList length
    public LinkedList returnNthNodeInList(LinkedList linkedList, int length, int N) {
        LinkedList node;

        if (N >= length) {
            while (linkedList.next != null) {
                linkedList = linkedList.next;
            }
        } else {
            for (int i = 0; i < N; i++) {
                linkedList = linkedList.next;
            }
        }
        node = linkedList;

        return node;
    }

    // return the Nth node in a LinkedList
    // case 2: with unknown LinkedList length
    public LinkedList returnNthNodeInList(LinkedList linkedList, int N) {
        LinkedList node;
        int i = 0;

        while (linkedList.next != null && i < N) {
            linkedList = linkedList.next;
            i++;
        }
        node = linkedList;

        return node;
    }

    // #Amazon
    // return the Nth node in a LinkedList from THE END of the list
    // with unknown LinkedList length
    // O(listSize + N)
    public LinkedList returnNthNodeInListFromEnd(LinkedList linkedList, int N) {
        LinkedList head = linkedList;
        int length = 0;

        while (linkedList.next != null) {
            linkedList = linkedList.next;
            length++;
        }

        if (N >= length) {
            return linkedList;
        }

        for (int i = 0; i < length - N; i++) {
            head = head.next;
        }

        return head;
    }

    // #Amazon
    // return the Nth node in a LinkedList from THE END of the list
    // with unknown LinkedList length
    // solution 2
    // O(listSize + N)
    public LinkedList returnNthNodeInListFromEndWithStack(LinkedList linkedList, int N) {
        Stack<LinkedList> linkedListNodeStack = new Stack<>();

        while (linkedList.next != null) {
            linkedListNodeStack.push(linkedList);
            linkedList = linkedList.next;
        }

        if (N >= linkedListNodeStack.size()) {
            return linkedListNodeStack.firstElement();
        }

        for (int i = 0; i < N; i++) {
             linkedListNodeStack.pop();
        }

        return linkedListNodeStack.lastElement();
    }

    // #Amazon
    // return the Nth node in a LinkedList from THE END of the list
    // with unknown LinkedList length
    // solution 3
    // O(listSize)
    public LinkedList returnNthNodeInListFromEndWithDoublePointers(LinkedList linkedList, int N) {
        LinkedList referenceNode = linkedList;
        LinkedList mainNode = linkedList;

        for (int i = 0; i < N; i++) {
            referenceNode = referenceNode.next;
        }

        while (referenceNode.next != null) {
            referenceNode = referenceNode.next;
            mainNode = mainNode.next;
        }

        return mainNode;
    }
}