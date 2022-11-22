package solution;

/**
 * @author LZN
 * @Title MaxPathSum
 * @ProjectName pattern
 * @Description 二叉树中的最大路径和
 * @date 2022-10-17 22:21
 **/
public class MaxPathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private int maxSum = Integer.MIN_VALUE;

    public int getMaxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 获取最大路径
     */
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归左右叶子节点贡献的最大值。
        // 只有当叶子节点的值大于0，才能提供贡献值
        int leftG = Math.max(maxGain(node.left), 0);
        int rightG = Math.max(maxGain(node.right), 0);
        // 当前节点的最大路径取决于该节点值与该节点左右子节点的最大贡献
        int newPathG=leftG+rightG+node.val;
        maxSum=Math.max(maxSum,newPathG);
        return node.val+Math.max(leftG,rightG);
    }
}
