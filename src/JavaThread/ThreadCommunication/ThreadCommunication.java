package JavaThread.ThreadCommunication;

import java.util.stream.IntStream;

class SharedResource {
    int data;
    boolean hasData;

    public synchronized void produce(int value){
        while (hasData){
            // IF DATA IS PRESENT then put thread on wait
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data =value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();
    }
    public synchronized void consume(){
        while (!hasData){
            // if data is not present then do not allow to consume the data
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
    }
}

class Producer implements Runnable {
    SharedResource resource;
     public Producer(SharedResource resource){
         this.resource = resource;
     }
        @Override
        public void run() {
            IntStream.range(0,10).forEach(number-> resource.produce(number));
        }
}

class Consumer implements Runnable {
    SharedResource resource;
    public Consumer(SharedResource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        IntStream.range(0,10).forEach(_ ->
            resource.consume()
        );
    }
}


public class ThreadCommunication {
    /*
     * 1. Without proper thread communication CPU wastage can be happened
     *      to avoid this we use ThreadCommunication
     * 2. Suppose we have Producer and consumer
     *      To check if task is completed by the producer we check continuously instead
     *      we ask producer to notify once it is done with task.
     * 3. Methods => wait(), notify(), notifyAll();
     * https://www.geeksforgeeks.org/inter-thread-communication-java/
     */

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));
        producerThread.start();
        consumerThread.start();
    }

    /* Output
    Produced: 0
    Consumed: 0
    Produced: 1
    Consumed: 1
    Produced: 2
    Consumed: 2
    Produced: 3
    Consumed: 3
    Produced: 4
    Consumed: 4
    Produced: 5
    Consumed: 5
    Produced: 6
    Consumed: 6
    Produced: 7
    Consumed: 7
    Produced: 8
    Consumed: 8
    Produced: 9
    Consumed: 9
    *
    * */
}
