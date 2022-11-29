package thread;

/**
 * @author LZN
 * @Title SwapPrint
 * @ProjectName my-test
 * @Description
 * @date 2022-11-29 15:22
 **/
public class SwapPrint {
    private volatile int i;
    private int limit;
    private final Object monitor = new Object();

    public SwapPrint(int i, int limit) {
        this.i = i;
        this.limit = limit;
    }

    public void print() {
        synchronized (monitor) {
            while (i < limit) {
                System.out.println("当前线程：" + Thread.currentThread().getName() + ":" + ++i);
                monitor.notifyAll();
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwapPrint swapPrint = new SwapPrint(0, 100);

        Thread thread1 = new Thread(swapPrint::print, "thread-1");
        Thread thread2 = new Thread(swapPrint::print, "thread-2");
        thread1.start();
        thread2.start();
    }
}
