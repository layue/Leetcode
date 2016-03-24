/**
 * Created by X on 24/03/2016.
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class Solution143 {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode frontHead = null;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;

            ListNode temp = slow.next;
            slow.next = frontHead;
            frontHead = slow;
            slow = temp;
        }

        ListNode backHead = slow.next;
        if (fast.next == null) {
            head = slow;
            head.next = null;
        } else {
            head = null;
            slow.next = frontHead;
            frontHead = slow;
        }

        connectList(frontHead, backHead, head);
    }

    public static ListNode connectList(ListNode front, ListNode back, ListNode head) {
        while (back != null) {
            ListNode frontTemp = front.next;
            ListNode backTemp = back.next;

            front.next = back;
            back.next = head;
            head = front;

            front = frontTemp;
            back = backTemp;
        }
        return head;
    }

    public static void main (String [] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        reorderList(head);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
