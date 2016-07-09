import java.util.Arrays;

/**
 * Created by X on 09/07/2016.
 */
public class BuildTree {
        /**
         *@param preorder : A list of integers that preorder traversal of a tree
         *@param inorder : A list of integers that inorder traversal of a tree
         *@return : Root of a tree
         */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1) {
            return root;
        }

        int subRoot = 0;
        for(;subRoot < inorder.length && inorder[subRoot] != root.val; subRoot ++);

        if(subRoot > 0) {
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, subRoot + 1),
                    Arrays.copyOfRange(inorder, 0, subRoot));
        }

        if(subRoot < preorder.length - 1) {
            root.right = buildTree(Arrays.copyOfRange(preorder, subRoot + 1, preorder.length), Arrays.copyOfRange(inorder, subRoot + 1, preorder.length));
        }

        return root;
    }

    public static void main(String [] args) {
        int[] pre = {1,2,3,4,5};
        int[] in = {1,2,3,4,5};

        System.out.println(buildTree(pre, in).val);
//        System.out.println(buildTree(null, null));
    }
}
