package JavaThread.CreateThread;

public class Main {
    public static void main(String[] args) {

        // Thread created using runnable interface
        RunnableThread runnableThread = new RunnableThread();
        java.lang.Thread thread = new java.lang.Thread(runnableThread);
        thread.start();

        // Thread created extending Thread class
        ThreadClass threadClass = new ThreadClass("myThread");
        // we can set the priority to the thread
        threadClass.setPriority(java.lang.Thread.MAX_PRIORITY);

        threadClass.start();
    }
}
