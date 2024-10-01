package JavaThread.Synchronization;

public class SynchThread extends Thread{
    private  Counter counter;
    public SynchThread(Counter counter){
        this.counter =counter;
    }
    @Override
    public void run(){
        for(int i = 0 ; i<1000; i++){
            counter.increment();
        }
    }
}
