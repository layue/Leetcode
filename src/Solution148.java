/**
 * Created by X on 20/03/2016.
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class Solution148 {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = devideList(head);
        ListNode back = middle.next;
        middle.next = null;

        return mergeList(sortList(head), sortList(back));
    }

    public static ListNode devideList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode mergeList(ListNode front, ListNode back) {
        ListNode result;
        ListNode now;

        if(front.val < back.val) {
            result = front;
            front = front.next;
        } else {
            result = back;
            back = back.next;
        }
        now = result;

        while(front != null && back != null) {
            if(front.val < back.val) {
                now.next = front;
                front = front.next;
            } else {
                now.next = back;
                back = back.next;
            }
            now = now.next;
        }

        if(front == null) {
            now.next = back;
        } else {
            now.next = front;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node = new ListNode(1);
        head.next = node;

        ListNode newNode = new ListNode(5);
        node.next = newNode;
        node = node.next;

        head = sortList(head);
    }
}
