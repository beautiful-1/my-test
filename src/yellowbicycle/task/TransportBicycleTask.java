package yellowbicycle.task;

import yellowbicycle.ArriveQueue;
import yellowbicycle.ICar;
import yellowbicycle.IStation;


/**
 * @author LZN
 * @Title TransportCartTask
 * @ProjectName my-test
 * @Description 运输车运输自行车的任务
 * @date 2022-11-25 15:34
 **/
public class TransportBicycleTask implements Runnable {
    double DEFAULT_LOAD_FACTOR = 0.75;
    IStation stationA = null;
    IStation stationB = null;
    IStation stationC = null;
    long disAB;
    long disAC;
    long disBC;


    public TransportBicycleTask(double DEFAULT_LOAD_FACTOR, IStation stationA, IStation stationB, IStation stationC, long disAB, long disAC, long disBC) {
        if (DEFAULT_LOAD_FACTOR > 0) {
            this.DEFAULT_LOAD_FACTOR = DEFAULT_LOAD_FACTOR;
        }
        this.stationA = stationA;
        this.stationB = stationB;
        this.stationC = stationC;
        this.disAB = disAB;
        this.disAC = disAC;
        this.disBC = disBC;
    }

    @Override
    public void run() {
        while (true) {
            long cur = System.currentTimeMillis();
            int cFlagBicycleNum = (int) (stationC.getInitCapacity() * DEFAULT_LOAD_FACTOR);
            int aFlagBicycleNum = (int) (stationA.getInitCapacity() * DEFAULT_LOAD_FACTOR);
            int bFlagBicycleNum = (int) (stationB.getInitCapacity() * DEFAULT_LOAD_FACTOR);
            boolean cState = stationC.getBicycle() > cFlagBicycleNum;
            boolean aState = stationA.getBicycle() > aFlagBicycleNum;
            boolean bState = stationB.getBicycle() > bFlagBicycleNum;
            //System.out.println("=====检查站点数据任务");
            // a站点的自行车数量小于一个阈值
            if (stationA.getBicycle() < aFlagBicycleNum) {
                // 从其他站点运输自行车
                if (bState) {
                    ICar car = stationB.outCar();
                    if (car != null) {
                        car.setToStation(stationA);
                        car.setDis(disAB / car.speed() + cur);
                        int add = car.add(stationB.getBicycle() - bFlagBicycleNum);
                        stationB.removeBicycle(add);
                        car.setCurStation(stationB);
                       // System.out.println("开始运输");
                        ArriveQueue.cars.add(car);
                    } else {
                        car = stationA.outCar();
                        if (car == null) {
                            car = stationC.outCar();
                            if (car != null) {
                                car.setDis(disAC / car.speed() + cur);
                                car.setToStation(stationB);
                                System.out.println("车辆调度");
                                ArriveQueue.cars.add(car);
                            }
                        } else {
                            car.setDis(disAB / car.speed() + cur);
                            car.setToStation(stationB);
                            System.out.println("车辆调度");
                            ArriveQueue.cars.add(car);
                        }
                    }

                }
                // 从c站给A运输自行车
                if (cState) {
                    ICar car = stationC.outCar();
                    if (car != null) {
                        car.setToStation(stationA);
                        car.setDis(disAC / car.speed() + cur);

                        int add = car.add(stationC.getBicycle() - cFlagBicycleNum);
                        // 运输走的移除C站点
                        stationC.removeBicycle(add);
                        car.setCurStation(stationC);
                     //   System.out.println("开始运输");
                        ArriveQueue.cars.add(car);

                    } else {
                        car = stationA.outCar();
                        if (car == null) {
                            car = stationB.outCar();
                            if (car != null) {
                                car.setDis(disBC / car.speed() + cur);
                                car.setToStation(stationA);
                                System.out.println("车辆调度");
                                ArriveQueue.cars.add(car);

                            }
                        } else {
                            car.setDis(disAC / car.speed() + cur);
                            car.setToStation(stationA);
                            System.out.println("车辆调度");
                            ArriveQueue.cars.add(car);

                        }
                    }

                }
            }
            // c站点车少了
            if (stationC.getBicycle() < cFlagBicycleNum) {
                // 从b站点运输到c
                if (cState) {
                    ICar car = stationB.outCar();
                    if (car != null) {
                        car.setToStation(stationC);
                        car.setDis(disBC / car.speed() + cur);
                        int add = car.add(stationB.getBicycle() - bFlagBicycleNum);
                        stationB.removeBicycle(add);
                        System.out.println("开始运输");
                        car.setCurStation(stationB);
                        ArriveQueue.cars.add(car);

                    } else {
                        car = stationA.outCar();
                        if (car == null) {
                            car = stationB.outCar();
                            if (car != null) {
                                car.setDis(disBC / car.speed() + cur);
                                car.setToStation(stationA);
                                System.out.println("车辆调度");
                                ArriveQueue.cars.add(car);

                            }
                        } else {
                            car.setDis(disAC / car.speed() + cur);
                            car.setToStation(stationA);
                            System.out.println("车辆调度");
                            ArriveQueue.cars.add(car);
                        }
                    }

                }
                if (aState) {
                    ICar car = stationA.outCar();
                    if (car != null) {
                        car.setToStation(stationC);
                        car.setDis(disAC / car.speed() + cur);
                        car.setCurStation(stationA);
                        int add = car.add(stationA.getBicycle() - aFlagBicycleNum);
                        stationA.removeBicycle(add);
                        System.out.println("开始运输");
                        ArriveQueue.cars.add(car);
                    } else {
                        car = stationA.outCar();
                        if (car == null) {
                            car = stationB.outCar();
                            if (car != null) {
                                car.setDis(disBC / car.speed() + cur);
                                car.setToStation(stationA);
                                System.out.println("车辆调度");
                                ArriveQueue.cars.add(car);
                            }
                        } else {
                            car.setDis(disAC / car.speed() + cur);
                            car.setToStation(stationA);
                            System.out.println("车辆调度");
                            ArriveQueue.cars.add(car);
                        }
                    }
                }
            }

            if (stationB.getBicycle() < bFlagBicycleNum) {
                if (aState) {
                    ICar car = stationA.outCar();
                    if (car != null) {
                        car.setToStation(stationB);
                        car.setDis(disAB / car.speed() + cur);
                        car.setCurStation(stationA);
                        int add = car.add(stationA.getBicycle() - aFlagBicycleNum);
                        stationA.removeBicycle(add);
                        System.out.println("开始运输");
                        ArriveQueue.cars.add(car);
                    } else {
                        car = stationB.outCar();
                        if (car == null) {
                            car = stationC.outCar();
                            if (car != null) {
                                car.setDis(disAC / car.speed() + cur);
                                car.setToStation(stationA);
                                System.out.println("车辆调度");
                                ArriveQueue.cars.add(car);
                            }
                        } else {
                            car.setDis(disAB / car.speed() + cur);
                            car.setToStation(stationA);
                            System.out.println("车辆调度");
                            ArriveQueue.cars.add(car);

                        }
                    }
                }
                if (cState) {
                    ICar car = stationC.outCar();
                    if (car != null) {
                        car.setToStation(stationB);
                        car.setDis(disBC / car.speed() + cur);
                        int add = car.add(stationC.getBicycle() - cFlagBicycleNum);
                        stationC.removeBicycle(add);
                        car.setCurStation(stationC);
                        System.out.println("开始运输");
                        ArriveQueue.cars.add(car);
                    } else {
                        car = stationA.outCar();
                        if (car == null) {
                            car = stationB.outCar();
                            if (car != null) {
                                car.setDis(disBC / car.speed() + cur);
                                car.setToStation(stationA);
                                System.out.println("车辆调度");
                                ArriveQueue.cars.add(car);

                            }
                        } else {
                            car.setDis(disAC / car.speed() + cur);
                            car.setToStation(stationA);
                            System.out.println("车辆调度");
                            ArriveQueue.cars.add(car);

                        }
                    }

                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
