import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by X on 28/02/2016.
 */
//  Hint
//    https://tsungmingliu.gitbooks.io/lets-leetcode/content/101_symmetric_tree/index.html

public class Solution101 {

//    Inorder taversel, wrong result for [2,2,2,2,2]
//    public static List allNode = new ArrayList();
//    public static void inOrder(TreeNode node) {
//
//        if(node.left == null & node.right == null) {
//            allNode.add(node.val);
//        } else if (node.left == null) {
//            allNode.add('#');
//            allNode.add(node.val);
//            inOrder(node.right);
//        } else if (node.right == null) {
//            inOrder(node.left);
//            allNode.add(node.val);
//            allNode.add('#');
//        } else {
//            inOrder(node.left);
//            allNode.add(node.val);
//            inOrder(node.right);
//        }
//    }
//
//    public static boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        if(root.left == null && root.right == null) {
//            return true;
//        }
//
//        inOrder(root);
//
//        int nNode = allNode.size();
//        for (int i = 0; i < nNode / 2; i ++) {
//            if(allNode.get(i) != allNode.get(nNode - i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//---------------------recursively----------------------
    public static boolean judgeSymmetric(TreeNode l, TreeNode r) {
        if(l == null && r == null) {
            return true;
        } else if(l == null || r == null) {
            return false;
        }

        if(l.val != r.val) {
            return false;
        }

        return judgeSymmetric(l.left, r.right) && judgeSymmetric(l.right, r.left);
    }
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return judgeSymmetric(root.left, root.right);
    }

//---------------------iteratively-----------------------
//    Hint:https://gist.github.com/AnotherStop/8979885
    public static boolean isSymmetricIte(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;

        Queue<TreeNode> lq = new LinkedList<TreeNode>();
        Queue<TreeNode> rq = new LinkedList<TreeNode>();

        lq.add(root.left);
        rq.add(root.right);
        TreeNode leftTemp = null;
        TreeNode rightTemp = null;

        while(lq.isEmpty() == false && rq.isEmpty() == false){
            leftTemp = lq.poll();
            rightTemp = rq.poll();

            if(leftTemp == null && rightTemp == null)
                continue;

            if((leftTemp == null && rightTemp != null) || (leftTemp != null && rightTemp == null))
                return false;

            if(leftTemp.val != rightTemp.val)
                return false;

            //take care of the order when adding left and right child to left and right queue
            lq.add(leftTemp.left);
            lq.add(leftTemp.right);

            rq.add(rightTemp.right);
            rq.add(rightTemp.left);
        }

        //since the left and right always have same size, at here both of them are empty

        return true;

    }
    public static void main (String [] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        boolean symmmetric = isSymmetricIte(root);
//        boolean symmmetric = isSymmetric(root);
        
        System.out.println(symmmetric);
    }
}
