package solution.dp;

/**
 * @author LZN
 * @Title MaxDifferentPathTwo
 * @ProjectName pattern
 * @Description 升级版的最大不同路径-障碍物
 * 算法结题思路
 * 1. 我们用f(i,j)来表示从坐标（0，0）到坐标（i，j）的路径总数，
 * 2. u(i,j)表示坐标(i,j)是否可行，若如果坐标u（i，j）有障碍物，u（i，j）=0，否则等于u（i，j）=1；
 * 3. 因为『机器每次只能向下或则向右移动一步』，所以坐标（0，0）到坐标（i，j）的路径总数等于 坐标（0，0）到（i-1，j）+坐标（0，0）到（i，j-1）之和
 * 4. 当坐标i，j本身就有障碍物的时候，任何路径都到不了，所以f（i，j）=0；
 * 5. 当坐标（i，j）没有障碍物的情况
 * 1）如果坐标（i-1，j）没有障碍物，那么就意味着从坐标 (i−1,j)可以走到 (i,j)，即 (i−1,j) 位置对 f(i,j) 的贡献为 f(i−1,j)
 * 2）同理，当坐标 (i,j−1)没有障碍的时候，(i,j−1) 位置对 f(i,j)的贡献为 f(i,j−1)
 * @date 2022-11-12 17:03
 **/
public class MaxDifferentPathTwo {
    public static int uniquePathWithObstacles(int[][] obstacles) {
        int m = obstacles.length;
        int n = obstacles[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            // 因为只能往下或者往后移动，所以遇到障碍物，后面的所有都为0；
            if (obstacles[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            // 因为只能往下或者往后移动，所以遇到障碍物，后面的所有都为0；
            if (obstacles[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacles[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
