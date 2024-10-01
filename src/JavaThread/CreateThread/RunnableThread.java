package JavaThread.CreateThread;

public class RunnableThread implements Runnable{
    @Override
    public void run() {
        for(int i= 0; i< 50; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
