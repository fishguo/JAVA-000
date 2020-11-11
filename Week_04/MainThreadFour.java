import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 利用CyclicBarrier等待子线程都达到一个状态，再回到主线程执行下面操作
 */
public class MainThreadFour {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            new Worker(i, barrier).start();
        }

        System.out.println("大伙都到状态了，主线程来主持工作了！");
    }

}

class Worker extends Thread {
    private CyclicBarrier barrier;
    private int i;

    public Worker (int i, CyclicBarrier barrier) {
        this.barrier =  barrier;
        this.i = i;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(2000);
            System.out.println(i+"线程加速到规定状态");
            barrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
