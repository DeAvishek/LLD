//There are two common ways to achieve this:
// 1️⃣ Synchronized Method 🔄
// When you declare an entire method as synchronized, the lock 🔐 is acquired on the object instance 
// (or on the Class object for static methods) before the method is executed and released after it finishes ✅.
public class SynchronizedMethod {
    private int count = 0;
    public synchronized void counter(){
        System.out.println("Synchronized Method - Start increment: " + Thread.currentThread().getName());
        count++;
        System.out.println("Synchronized Method - counter value: "+count);
        System.out.println("Synchronized Method - finsih task "+ Thread.currentThread().getName());
    }

    public static void main(String args[]){
        SynchronizedMethod sm = new SynchronizedMethod();
        Thread[]arr = new Thread[3];
        for(int i = 0;i<3;i++){
            arr[i] = new Thread(new Runnable() {
                public void run(){
                    sm.counter();
                }
            });
            arr[i].start();
        }

        for(int i=0;i<3;i++){
            try {
                arr[i].join();
            } catch (Exception e) {
                e.getMessage();
            }
        }
        
    }
}