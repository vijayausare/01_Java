package JavaThread.Lock.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private  final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try {
            System.out.println("Outer Method");
            this.innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void  innerMethod(){
        lock.lock();
        try {
            System.out.println("Outer Method");
            this.outerMethod();
        } finally {
            lock.unlock();
        }
    }

    /* *
    Conside if we call the Outer method
    1. Thread will be locked
    2. Then inner method gets called
    3. inner methods trie to lock the thread again , this may cause the Deadlock as
        the same thread is being dependent on the self to finish.
    4. In this case code runs as the ReentrantLock handles the same.
    5. Point to note here -> When we lock the thread 2 times , we should unlock this thread 2 times
    6. In scenario where we end the thread in the inner method new thread may enter int the first method
        This way the synchronization is maintained
    * */

}
