package song.basis.threadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Song on 2016/10/11.
 */
public class LiftOff implements Runnable{
    private static final LiftOff instance = new LiftOff();
    private Lock lock = new ReentrantLock();
    private int i=0;
    private LiftOff(){}
    public void run() {
        while(true) {
            synchronized (this) {
                if (i >= 500) {
                    System.out.println("Thread:" + Thread.currentThread().getId() + " is over" + "  " + this.i);
                    break;
                }
                System.out.println("Thread:" + Thread.currentThread().getId() + "        " + i);
                this.i++;
            }
        }
        Thread.currentThread().interrupt();
    }
    public synchronized void test(){
        while(true) {
            {
                if(i>=500){
                    System.out.println("Thread:" + Thread.currentThread().getId() + " is over"+"  "+this.i);
                    break;
                }
                System.out.println("Thread:" + Thread.currentThread().getId() + "        " + i);
                this.i++;
            }
        }
        Thread.currentThread().interrupt();

    }
    public static LiftOff getInstance(){
        return instance;
    }
}
