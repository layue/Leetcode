/**
 * Created by X on 08/04/2016.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class Solution83 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pos = head;
        while(pos != null) {
            if(pos.val == pos.next.val) {
                pos.next = pos.next.next;
            } else {
                pos = pos.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);

        head = deleteDuplicates(head);

        System.out.print(head);
    }
}
