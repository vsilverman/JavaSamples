import java.util.concurrent.Semaphore;
import java.lang.Runnable;
import java.lang.InterruptedException;

public class SemaphoreThreadTest implements Runnable {

    Semaphore binary = new Semaphore(1);
    int sleepTime;
    
    public SemaphoreThreadTest(int sleep) {
      sleepTime = sleep;
    }
  
    private void mutualExclusion() {
        try {
            binary.acquire();

            //mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
            Thread.sleep(sleepTime);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            binary.release();
            System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
        }
    } 
    
    public void run() {
    	mutualExclusion();
    }
    
    public static void main(String args[]) throws InterruptedException {
        final SemaphoreThreadTest test0 = new SemaphoreThreadTest(5000);
        Thread t0 = new Thread(test0);
        t0.start();

        final SemaphoreThreadTest test1 = new SemaphoreThreadTest(1000);
        Thread t1 = new Thread(test1);
        t1.start();
        
        while (t1.isAlive()) {
        	t0.join();
        	System.out.println("t1 alive; t0 ... after join");
        }
        
        while (t0.isAlive()) {
           	t1.join();
        	System.out.println("t0 alive; t1 ... after join");
        }

    }
}
