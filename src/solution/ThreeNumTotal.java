package solution;

import java.util.*;

/**
 * @author LZN
 * @Title ThreeNumTotal
 * @ProjectName pattern
 * @Description
 * @date 2022-10-16 17:30
 **/
public class ThreeNumTotal {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 3) {
            return resultList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int first = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = nums[j];
                int second = -(first + third);
                if (set.contains(second)) {
                    resultList.add(new ArrayList<>(Arrays.asList(first, third, -(first + third))));
                    while (j < nums.length - 1 && nums[j] == nums[j + 1])
                        j++;
                }
                set.add(third);
            }
        }
        return resultList;
    }
}
