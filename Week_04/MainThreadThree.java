import java.util.concurrent.CountDownLatch;

/**
 * 利用CountDownLatch控制多个子线程都完成再回到主线程.
 */
public class MainThreadThree {

    public static void main(String[] args) {
        final CountDownLatch downLatch = new CountDownLatch(2);
        new Thread(() -> {
            try {
                System.out.println("子线程1在执行");
                Thread.sleep(2000);
                downLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("子线程2在执行");
                Thread.sleep(2000);
                downLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            System.out.println("等待子线程执行完！");
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("终于轮到我主线程了！");


    }
}




