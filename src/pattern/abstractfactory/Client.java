package pattern.abstractfactory;

/**
 * @author LZN
 * @Title Client
 * @ProjectName pattern
 * @Description
 * @date 2022-08-22 22:53
 **/
public class Client {
    public static void main(String[] args) {
        Creator1 creator1 = new Creator1();
        AbstractCreator create2 = new Create2();
        // 产生A1对象
        AbstractProductA a1 = creator1.createProductA();
        AbstractProductB b1 = creator1.createProductB();
        a1.doSomething();
        b1.doSomething();
        AbstractProductA a2 = create2.createProductA();
        AbstractProductB b2 = create2.createProductB();
        a2.doSomething();
        b2.doSomething();
        /*
         * 然后就可以在这里做很多的事情
         * */
    }
    /*
    * 在场景类中,没有任何一个方法与实现类有关系,对于一个产品来说，我们只需要知道他的工厂方法就可以直接产生一个产品对象，无需关心他的实现类
    *
    * 抽象工厂模式的优点
    * ~封装性，每个产品的实现不是高层模块要关心的，他要关心的是什么呢，是接口、是抽象，他不需要关心对象是如何创建出来的，这由谁负责呢？工厂
    *   类，只要知道工厂类是谁，我就能创建出一个需要的对象，省时省力，优秀的设计就应该如此
    *
    * */
}
