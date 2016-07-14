import java.util.Stack;

/**
 * Created by X on 14/07/2016.
 */
public class IsSubtree {
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */

    public static boolean isIdentical(TreeNode T1, TreeNode T2) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(T1);
        s2.push(T2);
        while(!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode t1 = s1.pop();
            TreeNode t2 = s2.pop();

            if(t1 == null && t2 == null) {
                continue;
            } else if(t1 != null && t2 != null) {
                if(t1.val != t2.val) {
                    return false;
                } else {
                    s1.push(t1.right);
                    s1.push(t1.left);
                    s2.push(t2.right);
                    s2.push(t2.left);
                }
            } else {
                return false;
            }
        }
        return true;
    }
//T2 must be absolute part of T1. CANNOT be "include".
//A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
//That is, if you cut off the tree at node n, the two trees would be identical.
    public static boolean isSubtree(TreeNode T1, TreeNode T2) {

        if(T2 == null) {
            return true;
        }

        if(T1 == null && T2 != null) {
            return false;
        }
        Stack<TreeNode> nodeStack = new Stack<>();

        nodeStack.push(T1);
        while(!nodeStack.isEmpty()) {
            TreeNode temp = nodeStack.pop();
            if(isIdentical(temp, T2)) {
                return true;
            } else {
                if(temp != null) {
                    nodeStack.push(temp.right);
                    nodeStack.push(temp.left);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode T1 = new TreeNode(1);
        T1.left = new TreeNode(2);
        T1.right = new TreeNode(3);
        T1.left.left = new TreeNode(4);
        TreeNode T2 = new TreeNode(2);
        T2.left = new TreeNode(4);

        System.out.println(isSubtree(T1, T2));
    }
}
