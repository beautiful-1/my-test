package solution.dp;

import java.util.Arrays;

/**
 * @author LZN
 * @Title Test
 * @ProjectName pattern
 * @Description 求数组的最长递增子序列长度，例如输入数组[3,10,5,15,6,8]，输出4，对应子串为 [3,5,6,8]
 * 结题思路
 *
 * 状态定义：
 * dp[i]表示nums以nums[i]结尾的最长子序列的长度
 *
 * 转移方程
 * 设 j包含[0，i],每轮计算新的dp【i】时，遍历【0，i）列表区间，做一下判断：
 *  1.
 * @date 2022-11-11 11:34
 **/
public class MaxIncreaseSubNums {
    public static int getMaxSub(int[] nums){
        if (nums.length==0){
            return 0;
        }
        int[] result=new int[nums.length];
        int res=0;
        Arrays.fill(result,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    result[i]=Math.max(result[i],result[j]+1);
                }
            }
            res=Math.max(res,result[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints={0,3,1,6,2,2,7};
        int maxSub = getMaxSub(ints);
        System.out.println(maxSub);
    }
}
