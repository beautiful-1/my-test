package yellowbicycle.task;

import yellowbicycle.IBicycle;
import yellowbicycle.IStation;
import yellowbicycle.impl.YellowBicycle;

import java.util.concurrent.DelayQueue;

/**
 * @author LZN
 * @Title BicycleArriveTask
 * @ProjectName my-test
 * @Description
 * @date 2022-11-25 13:44
 **/
public class BicycleArriveTask implements Runnable {
    private final DelayQueue<YellowBicycle> tasks;
    private IStation stationA = null;
    private IStation stationB = null;
    private IStation stationC = null;

    public BicycleArriveTask(DelayQueue<YellowBicycle> tasks, IStation stationA, IStation stationB, IStation stationC) {
        this.tasks = tasks;
        this.stationA = stationA;
        this.stationB = stationB;
        this.stationC = stationC;
    }

    @Override
    public void run() {
        while (true) {
            if (tasks.isEmpty()) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                IBicycle peek = tasks.take();
                if (peek.getTo() == stationA) {
                    stationA.addBicycle(1);
                } else if (peek.getTo() == stationB) {
                    stationB.addBicycle(1);
                } else if (peek.getTo() == stationC) {
                    stationC.addBicycle(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
