package pattern.abstractfactory;

/**
 * @author LZN
 * @Title Creator1
 * @ProjectName pattern
 * @Description
 * @date 2022-08-22 22:50
 **/
public class Creator1 extends AbstractCreator{
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
