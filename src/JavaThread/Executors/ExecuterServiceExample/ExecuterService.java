package JavaThread.Executors.ExecuterServiceExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static JavaThread.ThreadPool.ThreadPool.facturial;

public class ExecuterService {

    public static void main(String[] args) {

        long startTime;

        /* this cached thead pools are dynamically adjust their size
            hreads are created depending upon the task size
        ExecuterService exe  = Executors.newCachedThreadPool(); */

        try (ExecutorService executors = Executors.newFixedThreadPool(9)) {
            startTime = System.currentTimeMillis();
            IntStream.range(1, 10).forEach(number -> {
                executors.submit(() -> {
                    System.out.println(facturial(number));
                });
            });

            // this is used to stop the loop
            // we can submit another task to the executors i.e thread reusabiliyty is there
            // once shut down s done we can not submit task to pool again
            executors.shutdown();

            while(!executors.awaitTermination(10, TimeUnit.MILLISECONDS)){
                System.out.println("Waiting");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Time required " + (System.currentTimeMillis() -startTime));

    }
}
