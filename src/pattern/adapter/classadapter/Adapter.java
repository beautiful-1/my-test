package pattern.adapter.classadapter;

import pattern.adapter.Source;
import pattern.adapter.Targetable;

/**
 * @author LZN
 * @Title Adapter
 * @ProjectName pattern
 * @Description
 * @date 2022-09-06 16:55
 **/
public class Adapter extends Source implements Targetable {

    @Override
    public void editWordFile() {
        System.out.println("编辑一个字符文件");
    }

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.editTextFile();
        adapter.editWordFile();
    }

    /*
     * 在使用适配器时只需定义一个实现了Targetable接口的Adapter类并调用Target中适配好的方法即可
     * 从运行结果中可以看出，我们的适配器不但实现了编辑Word文件的功能，还实现了编辑文本文件的功能
     * */
}
