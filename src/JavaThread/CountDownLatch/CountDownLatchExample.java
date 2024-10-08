package JavaThread.CountDownLatch;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOfTask = 3;
        /*
            1. This latch count the number of thread to be used
            2. It stops the main thread to execute the task
            3. Count down latch is not reusable
         */
        CountDownLatch latch = new CountDownLatch(numberOfTask);
        ExecutorService executerService = Executors.newFixedThreadPool(numberOfTask);
        executerService.submit(new DependentService(latch));
        executerService.submit(new DependentService(latch));
        executerService.submit(new DependentService(latch));

        // wait thread to complete its task
        latch.await();
        System.out.println("Main Thread Started");
        executerService.shutdown();
    }
}

class DependentService implements Callable<String> {
    private final CountDownLatch latch;

    DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try{
            System.out.println(Thread.currentThread().getName() + "started");
            Thread.sleep(3000);
            return "ok";
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // each time this will be counted
            latch.countDown();
        }
    }
}
