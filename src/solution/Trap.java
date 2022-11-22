package solution;

import java.util.LinkedList;

/**
 * @author LZN
 * @Title Trap
 * @ProjectName pattern
 * @Description 接雨水的最大量
 * @date 2022-10-17 14:58
 **/
public class Trap {
    public int trap(int[] height) {
        int ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > stack.peek()) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left=stack.peek();
                int curW=i-left-1;
                int curH=Math.min(height[left],height[i]-height[top]);
                ans=ans+curH*curW;
            }
            stack.push(i);
        }
        return ans;
    }
}
