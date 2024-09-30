package Synchronization;

public class Counter {
    private int cnt =  0;

    public void increment(){
        // avoid the synchronization issue
        // this refers to the single thread

        //  as shared memory is being used here this is called as
        // CRITICAL SECTION

        synchronized (this){
            // This is called as MUTUAL EXCLUSION
            cnt++;
        }
    }

    public int getCount(){
        return cnt;
    }
}
