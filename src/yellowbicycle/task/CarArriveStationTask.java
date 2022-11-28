package yellowbicycle.task;

import yellowbicycle.ArriveQueue;
import yellowbicycle.ICar;
import yellowbicycle.IStation;

/**
 * @author LZN
 * @Title CarArriveStationTask
 * @ProjectName my-test
 * @Description 运输车到站处理
 * @date 2022-11-25 16:38
 **/
public class CarArriveStationTask implements Runnable {
    long sleep;

    public CarArriveStationTask(long sleep) {
        this.sleep = sleep;
    }

    @Override
    public void run() {
        while (true) {
            // System.out.println("正在运行的运输车数量" + ArriveQueue.cars.size());
            if (!ArriveQueue.cars.isEmpty()) {
                ICar iCar = ArriveQueue.cars.poll();
                if (iCar != null) {
                    // 到达目的站点
                    IStation curStation = iCar.getToStation();
                    iCar.setCurStation(curStation);
                    // 将运输的自行车放入
                    curStation.addBicycle(iCar.getBicycle());
                    // 将运输车中的数据更新为0
                    iCar.delete();
                    // 运输车停到目的站点
                    curStation.inCar(iCar);
                }
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
