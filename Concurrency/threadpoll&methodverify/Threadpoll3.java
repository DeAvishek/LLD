import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Threadpoll3 {
    public static void main(String args[]){
        ThreadPoolExecutor Executor = new ThreadPoolExecutor(2,4, 10,TimeUnit.SECONDS,new ArrayBlockingQueue<>(2),
    new ThreadPoolExecutor.AbortPolicy());
        for(int i=0;i<10;i++){
            final int taskId = i; 
            Executor.execute(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+ "executes task id.."+taskId);
                    Thread.sleep(4000);
                    System.out.println("Task completed"+ taskId);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.getMessage();
                }
            });
        }
        Executor.shutdown();
    }
}
