package pattern.abstractfactory;
/**
* @author LZN
* @Title AbstractCreator
* @ProjectName pattern
* @Description
* @date 2022-08-22 22:47
**/
public abstract class AbstractCreator {
    /**
     * 请描述类的业务用途
     *@Author lzn
     *@Date 2022/8/22 22:48
     *@Version 1.0
     *@param
     *@return {@link null}
     **/
    public abstract AbstractProductA createProductA();
    /**
     * 请描述类的业务用途
     *@Author lzn
     *@Date 2022/8/22 22:50
     *@Version 1.0
     *@param
     *@return {@link null}
     **/
    public abstract AbstractProductB createProductB();
}
