import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 利用线程池起一队子线程然后拿到返回值并回到主线程.
 */
public class MainThreadOne {

    public static void main(String[] args) {
        //Callable<> have return value
        ExecutorService callablePool = Executors.newFixedThreadPool(10);

        List<Future> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Callable callable = new TestExecutorService("子线程" + i + " ");
            Future future =  callablePool.submit(callable);
            futureList.add(future);
        }

        callablePool.shutdown();

        for (Future futur:futureList) {
            try {
                System.out.println("这里是" + futur.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        //这里是主线程
        System.out.println("好开心啊！回到主线程了哦");
    }
}

class TestExecutorService implements Callable<String> {
    private String name;

    public TestExecutorService(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {

        return name;
    }

}
