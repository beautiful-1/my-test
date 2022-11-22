package queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author LZN
 * @Title DelayTask
 * @ProjectName pattern
 * @Description
 * @date 2022-11-18 14:49
 **/
public class DelayTask implements Delayed {
    long dealAt;
    int index;

    public DelayTask(long time, int ix) {
        dealAt = time;
        index = ix;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(dealAt - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayTask> tasks = new DelayQueue<>();
        long cur = System.currentTimeMillis();
        long[] delay = {15000L, 10000L, 5000L, 20000L};
        for (int i = 0; i < delay.length; i++) {
            DelayTask task = new DelayTask(delay[i] + cur, i);
            tasks.add(task);
        }
        while (!tasks.isEmpty()) {
            DelayTask peek = tasks.take();
            if (peek != null) {
                tasks.poll();
                System.out.println("时间间隔:"+ (System.currentTimeMillis() - cur) + "ms");
                System.out.println("当前任务序号：" + peek.index);cur = System.currentTimeMillis();
            }
            Thread.sleep(1000);
        }
    }
}
