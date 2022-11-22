package solution;

/**
 * @author LZN
 * @Title MInZs 返回数组中的最小正数
 * @ProjectName pattern
 * @Description
 * @date 2022-11-09 20:14
 **/
public class MInZs {
    static int missNum(int[] arr) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            if (arr[l]==l+1){
                l++;
            }else if (arr[l]<l+1||arr[l]>r||arr[arr[l]-1]==arr[l]){
                r--;
                arr[l]=arr[r];
            }
        }
        return l+1;
    }

    public static void main(String[] args) {
        int[] ss={2,2,3};
        int i = missNum(ss);
        System.out.println(i);
    }
}
