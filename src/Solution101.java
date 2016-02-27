import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by X on 27/02/2016.
 */
//  Hint
//    https://tsungmingliu.gitbooks.io/lets-leetcode/content/101_symmetric_tree/index.html

public class Solution101 {

    public static List allNode = new ArrayList();
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void inOrder(TreeNode node) {

        if(node.left == null & node.right == null) {
            allNode.add(node.val);
        } else if (node.left == null) {
            allNode.add('#');
            allNode.add(node.val);
            inOrder(node.right);
        } else if (node.right == null) {
            inOrder(node.left);
            allNode.add(node.val);
            allNode.add('#');
        } else {
            inOrder(node.left);
            allNode.add(node.val);
            inOrder(node.right);
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }

        inOrder(root);

        int nNode = allNode.size();
        for (int i = 0; i < nNode / 2; i ++) {
            if(allNode.get(i) != allNode.get(nNode - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main (String [] args) {
        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(3);

//        root.left = node1;
        root.right = node2;
//
//        node1.left = node3;
//        node1.right = node4;
//
//        node2.left = node5;
//        node2.right = node6;

        boolean symmmetric = isSymmetric(root);

        System.out.println(symmmetric);
    }
}
