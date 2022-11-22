package solution.dp;

/**
 * @author LZN
 * @Title MinPathSum
 * @ProjectName pattern
 * @Description 最小路径之和
 * 给定一个包含非负整数的m x n网格grid，请找出一条从左上角到右下角的路径，使得路径上的数字总和最小
 * 说明：一个机器人每次只能向下或者向右移动一步
 * 解题思路：
 * 由于路径的方向是只能向下或者向右，因此网格中的第一行的每个元素只能从左上角元素开始向右移动到达，
 * 网格的第一列的每个元素只能从左上角开始向下移动到达，此时的路径是唯一的，因此，每个元素对应的最小路径
 * 和即为每个元素对应的最小路径和即为对应路径上的数字总和。
 * <p>
 * 对于不再第一行和第一列的袁术，可以从其上方相邻的元素向下移动一步到达，或者从其左边相邻的元素向右移动一步到达
 * 元素对应的最小路径和等于其上方相邻的元素与其左方相邻的元素两者的最小值加上当前元素的值，
 * 由于每个元素对应的最小路径与其相邻的元素的最小路径和有关系，因此可以使用动态规划求解
 * <p>
 * 创建一个二维数组dp，与原来的网格大小相同
 * dp[i][j]表示从左上角出发到（i，j）的最小路径和
 * dp[0][0]=grid[0][0]
 * @date 2022-11-12 23:35
 **/
public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] += dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < columns; i++) {
            dp[0][i] += dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        int[][] grid =
                {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        minPathSum(grid);
    }
}
