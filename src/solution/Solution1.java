package solution;

/**
 * @author LZN
 * @Title Soltion
 * @ProjectName pattern
 * @Description
 * @date 2022-09-19 11:17
 **/
public class Solution1 {

    /**
     * 归并排序
     * 主要的流程
     * 1、分解
     * 2、归并
     * 归并排序的代码实现
     */
    public static int[] mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
        return data;
    }

    /**
     * 对左右两边的数据进行递归
     */
    public static void sort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        // 找出中间的索引
        int center = (left + right) / 2;
        // 对左边的数据进行递归
        sort(data, left, center);
        // 对右边的数据进行递归
        sort(data, center + 1, right);

        merge(data, left, center, right);
    }

    public static void merge(int[] data, int left, int center, int right) {
        // 创建临时数组
        int[] tmpArr = new int[data.length];
        // 右边数组第一个元素的索引
        int mid = center + 1;
        int third = left;
        // 缓存左边数组的第一个元素
        int tmp = left;
        while (left <= center && mid <= right) {
            // 两个数组总取出最小的值放在临时数组中
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }

        }
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }


        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }

    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        merge1(a, 0, 7, 13);


    }


    private static void merge1(int[] data, int p, int q, int r) {
        int[] B = new int[data.length];
        int s = p;
        int t = q + 1;
        int k = p;
        while (s <= q && t <= r) {
            if (data[s] <= data[t]) {
                B[k] = data[s];
                s++;
            } else {
                B[k] = data[t];
                t++;
            }
            k++;
        }
        if (s == q + 1) {
            B[k++] = data[t++];
        } else {
            B[k++] = data[s++];
        }
        for (int i = p; i <= r; i++) {
            data[i] = B[i];
        }
    }

    /**
     * 自己写一个合并一个数组中的 两段连续位置 数组从新排序
     */

    public static void merge2(int[] a, int left, int center, int right) {
        int[] tmpArr= new int[a.length];
        // 第一段要合并的位置
        int s1=left;
        // 第二段要合并的位置开始index
        int s2=center+1;
        // 还需要临时数组中的一个变量
        int k=left;
        while (s1<=left&&s2<=right){
            if (a[s1]<=a[s2]){
                tmpArr[k]=a[s1];
                s1++;
            }else {
                tmpArr[k]=a[s2];
                s2++;
            }
            k++;
        }
        if (s1==center+1){

        }
    }


    /*&
     * 1、 合并K个已经排序的链表
     * 说明：
     * 给定k个排好序的升序链表
     * 将这个K个链表合并成一个大的升序链表、并返回这个升序链表的头
     *
     *
     * 知识点：双指针
     * 双指针指的是在遍历对象的过程中，不是普通的使用单个指针进行访问，而是使用两个指针（特殊情况甚至可以使用多个指针），两个指针或者通方向访问两个链表、或者是同方向访问一个链表（快慢指针）、或者是相反方向扫描（对撞指针），从而达到
     * 我们的目的
     *
     * 知识点二：分治
     * 分治即"分而治之"，分 值得是将一个大而复杂的问题换分成多个性质相同但是规模更小的子问题，子问题继续按照这样划分，直到问题可以轻易解决；
     * "治" 指的是将子问题进行单独处理，经过分治后的子问题需要将解进行合并以后才能得到原问题的解，因此整个分治的过程经常使用递归来实现。
     * */


}
