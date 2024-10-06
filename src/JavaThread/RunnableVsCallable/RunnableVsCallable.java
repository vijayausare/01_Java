package JavaThread.RunnableVsCallable;

import java.util.concurrent.*;

public class RunnableVsCallable {
    /*
     * 1. Runnable do not have any return type
     * 2. Runnable do not throw any Exception in function signature
     * 2.1. Callable have return type
     * 2.2 Callable have Throw Error in the method signature
     * */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // this is try with resource block
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            Callable<String> callable = () -> "Hello Callable";
            Future<String> submit = executor.submit(callable);
            System.out.println(submit.get());

            // this seems like runnable but this is callable instance
            System.out.println(executor.submit(() -> "Hello this is Callable").get());

            executor.shutdown();
        }

        // this is similar like
   /*  Callable callable =new Callable() {
        @Override
        public Object call() throws Exception {
            return null;
        }
    } */
        // below code will not work
        // Runnable runnable = ()-> "Hello Runnabble";
    }


}
