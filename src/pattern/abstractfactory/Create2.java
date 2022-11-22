package pattern.abstractfactory;

/**
 * @author LZN
 * @Title Create2
 * @ProjectName pattern
 * @Description
 * @date 2022-08-22 22:51
 **/
public class Create2 extends AbstractCreator{
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
