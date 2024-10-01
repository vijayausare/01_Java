package JavaThread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance= 10000;

    private final Lock lock = new ReentrantLock();
    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() +" Attempting to Withdraw "+ amount);
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                // try lock will wait until the 1000 second to see if the thread is ended else will return falsse
                // in this case we have set waiting time as 1ms while first thead works for 3ms so another thread do
                // not get resource
                if(amount<= balance){
                    try {
                        Thread.sleep(3000);
                        balance-=amount;
                        System.out.println(Thread.currentThread().getName() +" Withdrawed "+ amount);
                    } catch (Exception e){

                    } finally {
                        lock.unlock(); // this is necessary to unlock the resources in the finally block
                    }
                }else {
                    System.out.println(Thread.currentThread().getName() +" Insufficient Balance!");
                }
            }else {
                System.out.println(Thread.currentThread().getName() +" Could not acquire Thread!");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
