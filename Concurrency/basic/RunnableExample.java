//HAS-A relationship
//Runnable define the work to do thread created separetely
//its a better approch two parts of thread separated 1.Thread Mechanics and 2.Task to do
class MyRunnable implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Thread id: "+Thread.currentThread().getId()+ "is running "+i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
class RunnableExample{
    public static void main(String[] args){
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        t1.start();
        t2.start();
    }
}