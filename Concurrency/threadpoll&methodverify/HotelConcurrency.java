public class HotelConcurrency {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread waiter = new ThreadWaiter(lock);
        Thread chef = new ThreadChief(lock);

        waiter.start();
        chef.start();
    }
}