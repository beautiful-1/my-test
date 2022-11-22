package pattern.adapter.objectadapter;

import pattern.adapter.Source;
import pattern.adapter.Targetable;

/**
 * @author LZN
 * @Title ObjectAdapter
 * @ProjectName pattern
 * @Description 在以下代码中定义了一个名为ObjectAdapter的适配器，该适配器实现了Targetable接口并持有Source实例，
 * 在适配器editTextFile()的方法中调用了Source实例提供的方法
 * @date 2022-09-06 21:30
 **/

public class ObjectAdapter implements Targetable {
    private final Source source;

    public ObjectAdapter(Source source){
        this.source=source;
    }
    @Override
    public void editTextFile() {
        source.editTextFile();
    }

    @Override
    public void editWordFile() {
        System.out.println("这是字符文件");
    }
    /**
     * 在使用对象适配器的时候，首先需要定义一个Source实例，然后在初始化ObjectAdapt时候将Source实例作为
     * 构造函数的参数传递进去，这样就实现了对象的适配
     * */
    public static void main(String[] args) {
        Source source = new Source();
        ObjectAdapter objectAdapter = new ObjectAdapter(source);
        objectAdapter.editWordFile();
        objectAdapter.editTextFile();
    }
}
