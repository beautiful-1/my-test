package test1;

/**
 * @author luzhengnan
 */
public interface IStation {
    /**
     * 获取车站当前的自行车数量
     *@Author lzn
     *@Date 2022/11/25 10:47
     *@Version 1.0
     *@param
     *@return {@link null}
     **/
    public int getBicycle();

    /**
     * 添加自行车
     *@Author lzn
     *@Date 2022/11/25 10:48
     *@Version 1.0
     *
     * @param n :添加数量*/
    public void addBicycle(int n);

    /**
     * 骑走自行车
     *@Author lzn
     *@Date 2022/11/25 10:48
     *@Version 1.0
     *@param ：
     *@return {@link null}
     **/
    public int removeBicycle(int n);

    public boolean carState();

    public void setCarState(boolean state);

    public int getInitCapacity();

    public int curBicycleNums();


    public ICar outCar();

    public void inCar(ICar car);

    public String getStationName();
}
