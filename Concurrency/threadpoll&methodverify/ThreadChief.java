import java.time.LocalDateTime;

public  class ThreadChief extends Thread{
    private final Object lock;
    public ThreadChief(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try{
                Thread.sleep(8000);
                System.out.println("Chef: Food is ready! Notifying the waiter. 🔔"+LocalDateTime.now());
                lock.notify();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}