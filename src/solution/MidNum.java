package solution;

/**
 * @author LZN
 * @Title MidNum
 * @ProjectName pattern
 * @Description 求俩个正序数组的中位数
 * <p>
 * 解法：
 * 1. 可以看做是求两个数组合并以后的中位数
 * 2. 如果两个数组的长度为n,
 * n为奇数，即求第n/2+1个最小数
 * n为偶数，即其n/2 +n/2+1 两个数的平均数
 * @date 2022-11-22 11:24
 **/
public class MidNum {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int mid = totalLength / 2;
            return getKthElement(nums1, nums2, mid + 1);
        } else {
            int mid1 = totalLength / 2 - 1;
            int mid2 = totalLength / 2;
            return (getKthElement(nums1, nums2, mid1 + 1) +
                    getKthElement(nums1, nums2, mid2 + 1)) / 2.0;
        }
    }

    /**
     * 求第n小数的思路
     * 要找到第k小的元素
     */
    public static double getKthElement(int[] nums1, int[] nums2, int k) {
        int mid = k / 2 - 1;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while (true) {
            // 边界情况
            // 数组1位空，直接返回数组2中第k小数
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            // 数组2为空，直接返回数组1中的第k小数
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            // 如果k==1，那么说明在两个数组中找到最小的数，只需要求两个数组的当前index 中最小的那个返回即可
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if (pivot1 < pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
