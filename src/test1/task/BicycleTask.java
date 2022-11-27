package test1.task;

import test1.ArriveQueue;
import test1.ICar;
import test1.IStation;
import test1.impl.YellowBicycle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.DelayQueue;

/**
 * @author LZN
 * @Title BicycleTask
 * @ProjectName my-test
 * @Description 一秒产生一个骑自行车任务
 * @date 2022-11-25 13:40
 **/
public class BicycleTask implements Runnable {
    long disAB = 15L;
    long disAC = 6L;
    long disBC = 10L;
    IStation stationA = null;
    IStation stationB = null;
    IStation stationC = null;
    DelayQueue<YellowBicycle> tasks;

    public BicycleTask(long disAB, long disAC, long disBC, IStation stationA, IStation stationB, IStation stationC, DelayQueue<YellowBicycle> tasks) {
        this.disAB = disAB;
        this.disAC = disAC;
        this.disBC = disBC;
        this.stationA = stationA;
        this.stationB = stationB;
        this.stationC = stationC;
        this.tasks = tasks;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int i = random.nextInt(9);
            int ii = random.nextInt(6);
            long cur = System.currentTimeMillis();
            if (i <= 3) {
                if (stationA.getBicycle() <= 0) {
                    return;
                }
                YellowBicycle yellowBicycle;
                if (ii <= 3) {
                    yellowBicycle = new YellowBicycle(stationA, stationB, true);
                    yellowBicycle.setDis((disAB / yellowBicycle.speed() + cur));
                } else {
                    yellowBicycle = new YellowBicycle(stationA, stationC, true);
                    yellowBicycle.setDis((disAC / yellowBicycle.speed() + cur));
                }
                tasks.add(yellowBicycle);
                stationA.removeBicycle(1);
            }
            if (3 < i && i <= 6) {
                if (stationB.getBicycle() <= 0) {
                    return;
                }
                YellowBicycle yellowBicycle;
                if (ii <= 3) {
                    yellowBicycle = new YellowBicycle(stationB, stationA, true);
                    yellowBicycle.setDis((disAB / yellowBicycle.speed() + cur));
                } else {
                    yellowBicycle = new YellowBicycle(stationB, stationC, true);
                    yellowBicycle.setDis((disBC / yellowBicycle.speed() + cur));
                }
                tasks.add(yellowBicycle);
                stationB.removeBicycle(1);
            }
            if (i > 6) {
                if (stationC.getBicycle() <= 0) {
                    return;
                }
                YellowBicycle yellowBicycle;
                if (ii <= 3) {
                    yellowBicycle = new YellowBicycle(stationC, stationB, true);
                    yellowBicycle.setDis(disBC / yellowBicycle.speed() + cur);
                } else {
                    yellowBicycle = new YellowBicycle(stationC, stationA, true);
                    yellowBicycle.setDis(disAC / yellowBicycle.speed() + cur);
                }
                tasks.add(yellowBicycle);
                stationC.removeBicycle(1);
            }
            int nums = 0;
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            System.out.print(format.format(new Date()) + ": ");
            System.out.print("A：" + stationA.getBicycle() + ", ");
            System.out.print("B：" + stationB.getBicycle() + ", ");
            System.out.print("C：" + stationC.getBicycle() + ", ");
            System.out.print("路上：" + tasks.size() + ", ");
            Iterator<ICar> iterator =
                    ArriveQueue.cars.iterator();
            if (iterator.hasNext()) {
                ICar next = iterator.next();
                if (next.getBicycle() > 0) {
                    nums += next.getBicycle();
                    IStation toStation = next.getToStation();
                    IStation curStation = next.getCurStation();
                    System.out.println(curStation.getStationName() + "正在ing到" + toStation.getStationName() + "运输:" + nums + "量车：");
                }else {
                    System.out.println();
                }

            }else {
                System.out.println();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
