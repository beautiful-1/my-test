package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;

/**
 * @author LZN
 * @Title MyThread
 * @ProjectName my-test
 * @Description
 * @date 2022-11-29 14:15
 **/
public class MyThread {
    private static volatile int i = 0;

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Print(semaphore));
        executorService.submit(new Print(semaphore));

    }

    static class Print implements Runnable {
        Semaphore semaphore;

        public Print(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            for (int j = 0; j < 50; j++) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i++);
                System.out.println(Thread.currentThread().getName());
                semaphore.release();
            }

        }
    }
}
