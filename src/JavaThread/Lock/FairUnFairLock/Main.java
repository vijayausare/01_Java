package JavaThread.Lock.FairUnFairLock;

public class Main {
    public static void main(String[] args) {
//        FairLock fairLock  = new FairLock();
//
//        Runnable fairLockRunnable = new Runnable() {
//            @Override
//            public void run() {
//                fairLock.accessResource();
//            }
//        };
//        Thread t1 = new Thread(fairLockRunnable, "Thread-1");
//        Thread t2 = new Thread(fairLockRunnable, "Thread-2");
//        Thread t3 = new Thread(fairLockRunnable, "Thread-3");
//        t1.start(); t2.start();;t3.start();
        /** OutPUT
         * Thread-1 Acquired The lock
         * Thread-1 released The lock
         * Thread-2 Acquired The lock
         * Thread-2 released The lock
         * Thread-3 Acquired The lock
         * Thread-3 released The lock
         */
        UnFairLock unFairLock  = new UnFairLock();

        Runnable unFairLockRunnable = new Runnable() {
            @Override
            public void run() {
                unFairLock.accessResource();
            }
        };
        Thread t11 = new Thread(unFairLockRunnable, "Thread-1");
        Thread t22 = new Thread(unFairLockRunnable, "Thread-2");
        Thread t33 = new Thread(unFairLockRunnable, "Thread-3");
        t11.start(); t22.start();;t33.start();
    }
}
