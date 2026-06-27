import java.util.concurrent.*;
//IS-A relation ship
//My class become a Thread
class MyThread extends Thread
{
    public void run()
    {
       for(int i=0;i<5;i++){
           System.out.println("Thread id :"+Thread.currentThread().getId()+" is running"+i);
           try{
               Thread.sleep(1000);
           }catch(InterruptedException e){
               System.out.println(e.getMessage());
           }
       }
    }
}
public class ThreadExample {
    public static void main(String[] args){
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t1.run(); //this is the main thread
    }
}

//and we can't call same threde object twice to start because--> one execution cycle after finish the thread terminates