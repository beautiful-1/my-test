package pattern.abstractfactory;

/**
 * @author LZN
 * @Title AbstractProductA
 * @ProjectName pattern
 * @Description
 * @date 2022-08-22 22:32
 **/
public abstract class AbstractProductA {
    /**
     * 请描述类的业务用途
     *@Author lzn
     *@Date 2022/8/22 22:33
     *@Version 1.0
     *@param
     *@return {@link null}
     **/
    public void shareMethod() {
        // do
    }
    /**
     * 每个产品相同实现，不同的做法
     *@Author lzn
     *@Date 2022/8/22 22:35
     *@Version 1.0
     *@param
     **/
    public abstract void doSomething();
}
