package yellowbicycle.impl;

import yellowbicycle.ArriveQueue;
import yellowbicycle.ICar;
import yellowbicycle.IStation;

import java.util.LinkedList;

/**
 * @author LZN
 * @Title StationA
 * @ProjectName my-test
 * @Description
 * @date 2022-11-25 10:49
 **/
public class StationImpl implements IStation {
    /**
     * 运输车当前的数量
     */
    private volatile int bicycleNum;
    /**
     * 运输车容量
     */
    private final int initBicycleNum;
    /**
     * 负责停运输车
     */
    private volatile LinkedList<ICar> cars = null;

    private String stationName;

    public StationImpl(int bicycleNum,String stationName) {
        this.initBicycleNum = bicycleNum;
        this.bicycleNum = bicycleNum;
        cars = new LinkedList<>();
        this.stationName=stationName;
    }

    @Override
    public int getBicycle() {
        return bicycleNum;
    }

    @Override
    public synchronized void addBicycle(int n) {
        bicycleNum = bicycleNum + n;
    }

    @Override
    public synchronized int removeBicycle(int n) {
        return bicycleNum = bicycleNum - n;
    }

    @Override
    public boolean carState() {
        return false;
    }

    @Override
    public void setCarState(boolean state) {

    }

    @Override
    public int getInitCapacity() {
        return initBicycleNum;
    }

    @Override
    public int curBicycleNums() {
        return bicycleNum;
    }

    @Override
    public synchronized ICar outCar() {
        return this.cars.poll();
    }

    @Override
    public synchronized void inCar(ICar car) {
        this.cars.add(car);
    }

    @Override
    public String getStationName() {
        return stationName;
    }

    public static void main(String[] args) {
        CarImpl car = new CarImpl(10);
        CarImpl car1 = new CarImpl(20);
        car1.setDis(10000L+System.currentTimeMillis());
        car.setDis(50000L+System.currentTimeMillis());
        ArriveQueue.cars.add(car);
        ArriveQueue.cars.add(car1);
        while (!ArriveQueue.cars.isEmpty()){
            ICar poll = ArriveQueue.cars.poll();
            System.out.println(poll);
        }

    }
}
