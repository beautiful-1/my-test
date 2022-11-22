package solution;

/**
 * @author LZN
 * @Title Sort
 * @ProjectName pattern
 * @Description
 * @date 2022-10-16 11:12
 **/
public class Sort {
    /**
     * 插入排序
     * */
    public static int[] insertSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            // 获取当前的第二个元素
            int current = array[i + 1];
            // 前一个元素
            int preIndex = i;
            // 首先需要前一个元素下表需要大于等于零，其次是当前元素如果是小于前一个元素
            while (preIndex >= 0 && current < array[preIndex]) {
                // 当前一个元素移动到当前的元素
                array[preIndex + 1] = array[preIndex];
                //
                preIndex--;
            }
            array[preIndex+1]=current;
        }
        return array;
    }

    public static void main(String[] args) {
        int [] a={32,3,5,2};
        insertSort(a);
    }

    /**
     * 归并排序 二路-归并排序
     * */
    public static int[] huiBingSort(int[] array){
        return null;
    }
}
