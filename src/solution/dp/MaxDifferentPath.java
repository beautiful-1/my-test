package solution.dp;

/**
 * @author LZN
 * @Title MaxPath
 * @ProjectName pattern
 * @Description 一个机器人位于m x n的网格的左上角，
 * 机器人每次只能向下或者向右移动一步，
 * 机器人试图达到网格的左下角
 * 总共有多少条不同的路径？
 * <p>
 * 解题思路：
 * 动态规划
 * 我们令 dp[i][j] 是到达i，j的最多路径
 * 动态方程：dp[i][j]=dp[i-1][j]+dp[i][j+1]
 * 注意，对于第一行dp[0][j] 或者第一列dp[i][0]由于都是在比边界，所以只能为1
 * 时间负载度O（m*n）
 * 空间负载度O（m*n）
 * @date 2022-11-12 16:20
 **/
public class MaxDifferentPath {
    public static int maxPath(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
