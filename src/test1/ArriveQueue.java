package test1;

import test1.impl.YellowBicycle;

import java.util.concurrent.DelayQueue;

/**
 * @author LZN
 * @Title ArriveQueue
 * @ProjectName my-test
 * @Description
 * @date 2022-11-25 16:30
 **/
public class ArriveQueue {
    public static volatile DelayQueue<IBicycle> bicycles =new DelayQueue<>();
    public static volatile DelayQueue<ICar> cars =new DelayQueue<>();
}
