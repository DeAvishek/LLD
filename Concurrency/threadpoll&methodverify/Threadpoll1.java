import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable{
    private final int taskId;
    public WorkerThread(int i){
        this.taskId = i;
    }

    @Override
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName()+" is procession task.. "+taskId);
            Thread.sleep(3000);
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
    }
}
