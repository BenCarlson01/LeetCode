public class ReversedLinkedList {

    /** Iterative Solution */
    public ListNode reverseList(ListNode head) {
        ListNode reversed = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = reversed;
            reversed = temp;
            head = head.next;
        }
        return reversed;
    }
}
