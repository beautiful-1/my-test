package solution.dp;

/**
 * @author LZN
 * @Title ClimbStairs
 * @ProjectName pattern
 * @Description 爬楼梯
 * 假设你正在爬楼梯，需要n阶才能到达楼顶
 * 每次可以1阶或2阶。你有多少种方法可以爬到楼顶
 *
 * 解题思路：动态规划
 * 动态规划的转移方程：
 * 我们用 f(x)表示爬到第 xxx 级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：
 * f(x)=f(x−1)+f(x−2)
 * 他意味着爬到第x级台阶的方案数是x-1 台阶的方案数和X-2 台阶方案数的和。因为每次只能爬1 台阶 或者2 台阶。
 * 所以f（x）只能从f（x-1) 和f(x-2)转移过来，而这里要统计的方案总数，我们就需要这两项的贡献求和
 *
 * 以上是动态规划的转移方程，下面我们来讨论边界条件。 我们是从0开始爬的，所以f（0）=1；
 * f（1）=1
 * f（2）=2
 * f（3）=3
 * f（4）=5
 *  ....
 * 以上结果，不难发现，我们的推导是正确的
 * 我们不难通过转移方程和边界条件给出一个时间复杂度和空间复杂度为O（n）的实现，但是这里由于f（x）只是跟f（x-1）和f(x-2)有关系
 * 所以，我们可以利用滚动数组的思想，把空间负责度降低为O（1）
 *
 *
 * @date 2022-11-12 22:21
 **/
public class ClimbStairs {
    /**
     * 空间复杂度为O（n）的实现算法
     * */
    public static int climbStairs(int n){
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i = 3; i < n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
    /**
     * 使用滑动数组，空降复杂度降低为o（1）
     * */
    public static int climbStairs1(int n){
        int pre=1;
        if (n<=1){
            return pre;
        }
        int current=2;
        for (int i = 2; i < n; i++) {
            int temp=current;
            current+=pre;
            pre=temp;
        }
        return current;
    }
}
