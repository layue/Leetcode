import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by X on 08/04/2016.
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 return [1,3,2].
 */
public class Solution94 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();

        if(root == null) {
            return result;
        }

        Stack<TreeNode> s = new Stack();
        TreeNode node = root;

        while(!s.isEmpty() || node != null) {

            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                TreeNode n = s.pop();
                result.add(n.val);
                node = n.right;
            }
        }
        // result.addAll(traversal(root));
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        List<Integer> result = inorderTraversal(root);
        System.out.print(result);
    }
}
