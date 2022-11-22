package solution;

import java.util.HashMap;

/**
 * @author LZN
 * @Title RecoverTreeNode
 * @ProjectName pattern
 * @Description
 * @date 2022-10-30 22:37
 **/
public class RecoverTreeNode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static final HashMap<Integer, Integer> member = new HashMap<>();
    private static int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            member.put(inorder[i], i);
        }
        post = postorder;
        return buildTreeNode(0, inorder.length - 1, 0, post.length - 1);
    }

    public TreeNode buildTreeNode(int inStart, int inEnd, int postStart, int postEnd) {
        if (inEnd < inStart || postEnd < postStart) {
            return null;
        }
        int root = post[postEnd];
        int rootIndex = member.get(root);
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = buildTreeNode(inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1);
        rootNode.right = buildTreeNode(rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1);
        return rootNode;
    }
}
