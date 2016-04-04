import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by X on 04/04/2016.
 */
public class Solution144 {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();

        if(root == null) {
            return res;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);

        while(!s.isEmpty()) {
            TreeNode n = s.pop();
            if(n != null) {
                res.add(n.val);

                s.push(n.right);
                s.push(n.left);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left =new TreeNode(3);

        List<Integer> res = preorderTraversal(root);

        System.out.print(res);
    }
}
