package yellowbicycle;

import yellowbicycle.impl.CarImpl;
import yellowbicycle.impl.StationImpl;
import yellowbicycle.impl.YellowBicycle;
import yellowbicycle.task.BicycleArriveTask;
import yellowbicycle.task.CarArriveStationTask;
import yellowbicycle.task.BicycleTask;
import yellowbicycle.task.TransportBicycleTask;

import java.util.concurrent.*;

/**
 * @author LZN
 * @Title CyclicUtilization
 * @ProjectName my-test
 * @Description
 * @date 2022-11-25 10:54
 **/
public class Main {
    private static ExecutorService executorService = Executors.newFixedThreadPool(4);
    private static ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private static volatile DelayQueue<YellowBicycle> tasks = new DelayQueue<>();
    ;

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        long disAB = 15*1000L;
        long disAC = 6*1000L;
        long disBC = 10*1000L;
        IStation stationA = new StationImpl(30,"A");
        IStation stationB = new StationImpl(40,"B");
        IStation stationC = new StationImpl(30,"C");
        ICar carA = new CarImpl(20);
        ICar carB = new CarImpl(20);
        stationA.inCar(carA);
        stationC.inCar(carB);
        executorService.execute(new BicycleTask(disAB, disAC, disBC, stationA, stationB, stationC, tasks));
        executorService.execute(new BicycleArriveTask(tasks, stationA, stationB, stationC));
        executorService.execute(new TransportBicycleTask(0.75,stationA,stationB,stationC,disAB,disAC,disBC));
        executorService.execute(new CarArriveStationTask(1000));
    }
}
