// 2️⃣ Synchronized Block 🧱🔒
// A synchronized block allows you to specify a particular block of code to be synchronized, 
// along with the object on which to acquire the lock (often called a monitor 🧭). This is more fine-grained 
// compared to a synchronized method.
// ✅ You can perform non-critical work outside the block, 
// while only protecting the portion of code that truly requires exclusive access 🚫👥.


public class SynchronizedBlock {
    private final Object lock = new Object();
    private int count = 0;
    private int getFinalcount(){
        return count;
    }

    private void counter(){
        System.out.println("Perform some non critical task....");
        synchronized(lock){
            System.out.println("Synchronized Method - Start increment: " + Thread.currentThread().getName());
            count++;
            System.out.println("Synchronized Method - Counter value: "+count);
            System.out.println("Synchronized Method - Finsih task: "+ Thread.currentThread().getName());
        }
    }
    public static void main(String[]args){
        SynchronizedBlock sb = new SynchronizedBlock();
        Thread[]Threads = new Thread[5];
        for(int i=0;i<5;i++){
            Threads[i] = new Thread(new Runnable() {
                public void run(){
                    sb.counter();
                }
            });
            Threads[i].start();
        }
        for(int i=0;i<5;i++){
            try {
                Threads[i].join();
            } catch (Exception e) {
                e.getMessage();
            }
        }
        System.out.println("get final count: "+sb.getFinalcount());
    }
}
