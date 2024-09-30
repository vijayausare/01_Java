package Threads;

public class ThreadClass extends  Thread{

    public ThreadClass(String name){
        super(name);
    }
    @Override
    public  void run(){
        for(int i= 0; i< 50; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
