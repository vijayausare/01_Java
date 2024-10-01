package JavaThread.Lock.FairUnFairLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public  class FairLock{
    private final boolean fair =true;
    private Lock lock= new ReentrantLock(fair);

    public void accessResource(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() +" Acquired The lock");
            Thread.sleep(1000);
        } catch (Exception e){
            Thread.currentThread().interrupt();
        }
        finally {
            System.out.println(Thread.currentThread().getName() +" released The lock");
            lock.unlock();
        }
    }
}


