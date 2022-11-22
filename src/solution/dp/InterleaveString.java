package solution.dp;

/**
 * @author LZN
 * @Title StringInterleave
 * @ProjectName pattern
 * @Description 交错字符串
 * 题目描述
 * 给定三个字符串s1 s2 s3 请你帮忙验证s3是否是s1和s2交错组成的
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * <p>
 * 思路分析：
 * 『双指针法错在哪里？ 也许有同学看到这个题目的第一反应是使用双指针发解决这个问题，指针p1一开始指向s1的头部
 * 指针p2一开始指向s2的头部，指针p3指向s3的头部。每次观察p1和p2指向的元素哪一个和p3指向的元素相等，相等则匹配并后移
 * 指针』
 * <p>
 * 1. 解决这个问题的正确方法是动态规划，首先如果|s1|+|S2|!=|S3|,那么s3必然不可能由s1和s1交错组成
 * 2. 在s1+s2=s3时，我们可以用动态规划的来求解。我们定义f（i，j）表示s1的前i和元素和s2的前j个元素能否
 * 交错组成s3的前j+i个元素。如果s1的第i个元素和s3的第i+j个元素相等，那么s1的前i个元素和s2的前j个元素是否能
 * 交错组成s3的前面i+j个元素取决于s1的钱
 * @date 2022-11-13 15:29
 **/
public class InterleaveString {
    public static boolean interleaveString(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[n][m];
    }
}
