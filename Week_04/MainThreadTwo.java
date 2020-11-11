import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用ReentrantLock加锁使子线程运行完后回到主线程.
 */
public class MainThreadTwo implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 5; j++) {
            lock.lock();
            try {
                i++;
                System.out.println("我是子线程" + i);
            }finally {
                lock.unlock();
            }


        }
    }

    public static void main(String[] args) throws InterruptedException {
        MainThreadTwo Fish = new MainThreadTwo();
        Thread t1 = new Thread(Fish);
        t1.start();
        t1.join();
        System.out.println("好开心！我主线程又回来了！");
    }
}
