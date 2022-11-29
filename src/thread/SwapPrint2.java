package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LZN
 * @Title SwapPrint2
 * @ProjectName my-test
 * @Description 两个线程交错打印实现方式二
 * @date 2022-11-29 19:01
 **/
public class SwapPrint2 {
    private final int limit;
    private volatile int count;
    Object monitor = new Object();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public SwapPrint2(int limit, int count) {
        this.limit = limit;
        this.count = count;
    }

    private void print() {
        lock.lock();

        try {
            while (count < limit) {
                System.out.println("当前线程：" + Thread.currentThread().getName() + " ; count" + ++count);
                condition.signalAll();
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        SwapPrint2 swapPrint2 = new SwapPrint2(100, 0);
        Thread thread = new Thread(swapPrint2::print, "thread-1");
        Thread thread1 = new Thread(swapPrint2::print, "thread-2");
        thread1.start();
        thread.start();

    }
}
