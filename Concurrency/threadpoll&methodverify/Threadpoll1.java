//cpu-intesive task newFixedThreadPoll(cores/thread)
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WorkerThread implements Runnable{
    private final int taskId;
    public WorkerThread(int i){
        this.taskId = i;
    }

    @Override
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName()+" is procession task.. "+taskId);
            Thread.sleep(9000);
            System.out.println(Thread.currentThread().getName()+" is finsished task.. "+taskId);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
public class Threadpoll1 {
    public static void main(String[]args){
        ExecutorService executer = Executors.newFixedThreadPool(3);
        for(int i=0;i<9;i++){
            executer.submit(new WorkerThread(i));
        }

        executer.shutdown();
        System.out.println("Thread Pool Shutdown Initiated 🚦"); 
        try {
            if(!executer.awaitTermination(10, TimeUnit.SECONDS)){ //wait for 10 sec after that forcefully terminate
                executer.shutdownNow();
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            executer.shutdownNow();
        }
        System.out.println("All Threads Terminated ✅"); 
    }
}
