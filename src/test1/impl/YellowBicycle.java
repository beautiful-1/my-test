package test1.impl;

import test1.IBicycle;
import test1.IStation;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author LZN
 * @Title YellowBicycle
 * @ProjectName my-test
 * @Description
 * @date 2022-11-25 10:42
 **/
public class YellowBicycle implements IBicycle {
    public IStation from;
    public IStation to;
    private boolean state;
    private long dis;

    public YellowBicycle(IStation from, IStation to, boolean state) {
        this.from = from;
        this.to = to;
        this.state = state;
    }

    @Override
    public int speed() {
        return 1;
    }


    @Override
    public IStation getTo() {
        return to;
    }

    @Override
    public void setDis(long dis) {
        this.dis = dis;
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

    public IStation getFrom() {
        return from;
    }

    public void setFrom(IStation from) {
        this.from = from;
    }

    public void setTo(IStation to) {
        this.to = to;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
