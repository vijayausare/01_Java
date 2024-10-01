package JavaThread.Synchronization;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        // two thread are sharing the same resource/object
        SynchThread t1= new SynchThread(counter);
        SynchThread t2 = new SynchThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());
        // it will not print the 2000 as same resource is being used here
        // THIS IS KNOWN AS RACE CONDITION
        // to solve same issue we will modify the increment method present in Counter class

    }
}
