/**
 * Created by X on 04/04/2016.
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Solution21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }

        ListNode head;
        if(l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode p = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if(l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }

        return head;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(9);

        ListNode res = mergeTwoLists(l1, l2);

        while(res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
