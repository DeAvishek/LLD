import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoll2 {
    private static void task(){
        try{
            System.out.println("performing task..." +Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("finshed" +Thread.currentThread().getName());
        }catch(Exception e){
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String []args){
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores);
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0;i<16;i++){
            executor.execute(()->{
                task();

            });
        }
        executor.shutdown();

    }
}