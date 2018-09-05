public class ThreadLifeCycle {
    public static void main(String args[]) throws Exception {
    
       //Runnable r = () -> { System.out.println(Thread.currentThread().getName()); };
       Thread t1 = new Thread(() -> { // anonymous runnable interface using lambda
           int i = 5;
           while(i > 0) {
           try { Thread.sleep(1000); } catch(Exception e ){}
           printCurrentThreadState(null);
           i--;
           }
       }, "thread1");
       
       printCurrentThreadState(t1);
       
       Thread t2 = new Thread(() -> { // anonymous runnable interface using lambda
            printCurrentThreadState(null);
       }, "thread2");
       
       printCurrentThreadState(t2);
       
       t1.start();
       t2.start();
       t1.join();
       t2.join();
       printCurrentThreadState(t1);
       printCurrentThreadState(t2);
    }
    
    public static void printCurrentThreadState(Thread t) {
        Thread currentThread = (t == null) ? Thread.currentThread() : t;
        System.out.println(currentThread.getName() + " -> " + currentThread.getState());
    }
}
