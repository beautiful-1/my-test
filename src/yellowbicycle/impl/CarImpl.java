package yellowbicycle.impl;

import yellowbicycle.ICar;
import yellowbicycle.IStation;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author LZN
 * @Title CarImpl
 * @ProjectName my-test
 * @Description
 * @date 2022-11-25 10:43
 **/
public class CarImpl implements ICar {
    private final int capacity;
    private int curNum;
    private long dis;
    private IStation curStation;
    private IStation fromStation;
    private IStation toStation;
    private DelayQueue<YellowBicycle> tasks;


    public CarImpl(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int speed() {
        return 3;
    }

    @Override
    public int add(int n) {
        if (curNum + n <= capacity) {
            curNum+=n;
            return n;
        } else {
            curNum+=capacity - curNum;
            return capacity - curNum;
        }
    }

    @Override
    public int delete() {
        int n = curNum;
        curNum = 0;
        return n;
    }

    @Override
    public void setToStation(IStation iStation) {
        toStation = iStation;
    }

    @Override
    public void setCurStation(IStation iStation) {
        curStation = iStation;
    }

    @Override
    public IStation getCurStation() {
        return curStation;
    }

    @Override
    public IStation getToStation() {
        return toStation;
    }

    @Override
    public void setDis(long dis) {
        this.dis = dis;
    }

    @Override
    public int getBicycle() {
        return curNum;
    }


    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(dis - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        } else {
            return -1;
        }
    }

}
