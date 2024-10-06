package JavaThread.ThreadPool;

import java.util.stream.IntStream;

public class ThreadPool {
    /*
     * this is collection of pre initialized threads
     * 1. Used for resource management
     * 2. Increase in response time
     * 3. Control over thread count
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[10];
        IntStream.range(1, 10).forEach(number -> {
            threads[number-1] = new Thread(()->{
                System.out.println(facturial(number));
            });
            threads[number-1].start();
        });

        for (int i = 0; i < 10; i++) {
                for (Thread thread : threads) {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        }

        System.out.println("Time required " + (System.currentTimeMillis() -startTime));
    }

    public static long facturial(int number) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long res = 1;
        for (int i = 1; i < number; i++) {
            res *= i;
        }
        return res;
    }

}
