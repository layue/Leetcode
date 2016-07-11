/**
 * Created by X on 11/07/2016.
 */
public class DeleteNodeO1 {
    public static void deleteNode(ListNode node) {
        // write your code here
        if (node == null || node.next == null) {
            node = null;
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;

//        if(node.next != null) { //中间节点
//            node.val = node.next.val;
//            node.next = node.next.next;
//        } else if(node == head) { //是头也是尾
//            head = null;
//        } else { //尾节点
//            loop from head to delete
    }

    public static void main(String [] args) {
        ListNode root = new ListNode(1);
        deleteNode(root);
    }
}