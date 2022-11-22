package pattern.adapter.interfaceadapter;

/**
 * @author LZN
 * @Title AbstractAdapter
 * @ProjectName pattern
 * @Description 如下代码定义了对SourceAble的实现，该类对SourceAble进行了从写，但是不做具体的事情
 * @date 2022-09-06 22:06
 **/
public abstract class AbstractAdapter implements SourceAble{
    /**
     * 字符
     */
    @Override
    public void editWordFile(){};

    /**
     * 文本
     */
    @Override
    public void editTextFile(){};
}
