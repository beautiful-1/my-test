package solution.dp;

/**
 * @author LZN
 * @Title CatchRainWater
 * @ProjectName my-test
 * @Description 接雨水
 * <p>
 * 解法：动态规划
 * 对于下表i，下雨以后能到达最大高度等于下标i量表高度的最小值，下标i能出能接的雨水等于
 * 下标i处能接的雨水链等于下标i处的水达到的最大高度减去height[i].
 * 1.朴素的做法是对于数组height中的每个元素，分别向左和向右扫描记录左边和右边的最大高度
 * 2. 计算每个下标能接住的雨水量
 * 3. 创建两个长度为n的数组，leftMax和rightMax，对于0<=i<n
 * @date 2022-11-24 10:04
 **/
public class CatchRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
