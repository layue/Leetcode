/**
 * Created by X on 14/07/2016.
 */
public class DeleteLastNthNode {
//head == null
//n == 0
//n > list.length
//n = list.length
//n < list.length
    public static ListNode deleteLastN (ListNode head, int n) {
        if(head == null || n == 0) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(n >= 0 && fast != null) {
            fast = fast.next;
            n --;
        }

        if (n == 0) {
            head = head.next;
        } else {
            while(fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        return head;
    }
}