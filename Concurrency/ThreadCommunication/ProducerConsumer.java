package ThreadCommunication;
import java.util.*;
public class ProducerConsumer{
    private Queue<Integer>q = new LinkedList<>();
    private final int CAPACITY = 5;
    private Object lock = new Object();
    public void produce() throws InterruptedException{
        int value = 0;
            while (true) {
                synchronized(lock){
                    if(q.size()==CAPACITY){
                        // notify();
                        lock.wait();
                    }
                    System.out.println("Producer produce item number.."+value);
                    q.offer(value++);
                    lock.notify();
                    //time to make product
                }   
                 Thread.sleep(1000);
            }
    }
    public void consume() throws InterruptedException{
        while(true){
            synchronized(lock){
                if(q.size()==0){
                    // notify();
                        lock.wait();
                       
                    }
                
                int item = q.poll();
                System.out.println("consumer consumes item number.."+item);
                lock.notify();
                // Thread.sleep(1000); //to consume the item
            }
            Thread.sleep(5000);
        }
    }
    public static void main(String []args){
        ProducerConsumer pc = new ProducerConsumer();
        Thread pro = new Thread(new Runnable() {
            public void run(){
                try {
                    pc.produce();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                
            }
        },"Producer");

        Thread con = new Thread(new Runnable() {
            public void run(){
                try {
                    pc.consume();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        },"consumer");
        pro.start();
        con.start();
    }
}
