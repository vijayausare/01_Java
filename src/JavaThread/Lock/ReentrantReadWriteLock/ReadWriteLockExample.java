package JavaThread.Lock.ReentrantReadWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class ReadWriteLockExample {
    private int count = 0 ;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private  final Lock writeLock = lock.writeLock();

    public void increment(){
        try{
            writeLock.lock();
            count++;
            Thread.sleep(50);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }

    public int readCount(){
        try{
            readLock.lock();
            // multiple threads can acquire the lock  in this class ReentrantReadWriteLock
            // only if write lock is not acquired by any thread
            return count;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        finally {
            readLock.unlock();
        }
    }


    /***********************************************/
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample readWriteLockExample = new ReadWriteLockExample();

        Runnable readTask = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+ "Read" + readWriteLockExample.readCount());
            }
        };

        Runnable writeTask = ()-> {
                IntStream.range(0, 10).forEach(_ -> {
                    readWriteLockExample.increment();
                    System.out.println(Thread.currentThread().getName() + "Incremented");
                });
        };

        Thread writeThread = new Thread(writeTask, "WriteThread");
        Thread readThread1 = new Thread(readTask,"ReadThread-1");
        Thread readThread2 = new Thread(readTask,"ReadThread-2");

        writeThread.start(); readThread1.start();readThread2.start();
        writeThread.join(); readThread1.join();readThread2.join();

        System.out.println(readWriteLockExample.readCount());

        /*  OUTPUT:
        *       WriteThreadIncremented
                WriteThreadIncremented
                ReadThread-2Read1
                ReadThread-1Read1
                WriteThreadIncremented
                WriteThreadIncremented
                ReadThread-2Read4
                ReadThread-1Read4
                WriteThreadIncremented
                ReadThread-2Read6
                ReadThread-2Read6
                ReadThread-1Read6
                ReadThread-1Read6
                ReadThread-1Read6
                ReadThread-1Read6
                ReadThread-1Read6
                ReadThread-1Read6
                ReadThread-1Read6
                ReadThread-1Read6
                WriteThreadIncremented
                WriteThreadIncremented
                ReadThread-2Read8
                ReadThread-2Read8
                ReadThread-2Read8
                ReadThread-2Read8
                ReadThread-2Read8
                ReadThread-2Read8
                WriteThreadIncremented
                WriteThreadIncremented
                WriteThreadIncremented
                10
        * */
    }
}
