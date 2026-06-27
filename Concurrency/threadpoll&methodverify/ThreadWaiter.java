public class ThreadWaiter extends Thread {
    private final Object lock;

    public ThreadWaiter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("Waiter:takes the order..");
                System.out.println("Waiter: Waiting for the food to be ready..");
                lock.wait(); // Waiter enters WAITING state
                System.out.println("Waiter: Food is ready! Delivering to the customer");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}