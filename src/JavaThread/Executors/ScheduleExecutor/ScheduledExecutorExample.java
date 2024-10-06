package JavaThread.Executors.ScheduleExecutor;

import java.util.concurrent.*;

public class ScheduledExecutorExample {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(()-> System.out.println("task executed after each 5 seconds irresptive of other task"), 5,5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(()-> System.out.println("task executed after each 5 seconds with delay of task"), 5,5, TimeUnit.SECONDS);

        scheduledExecutorService.schedule(()-> {
            System.out.println("Terminating The Thread after 20 seconds");
            scheduledExecutorService.shutdown();
                }, 20, TimeUnit.SECONDS
        );
    }
}
