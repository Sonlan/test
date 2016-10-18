package song.threadTest.NotifyTest;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Song on 2016/10/18.
 */
public class NotifyAndNotifyAll {
    public static void main(String [] args) throws Exception{
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            es.execute(new Task());
        }
        es.execute(new Task2());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if(prod){
                    System.out.println("\n notify()");
                    Task.blocker.prod();
                    prod=false;
                }else {
                    System.out.println("\nnotifyAll()");
                    Task.blocker.prodAll();
                    prod=true;
                }
            }
        },5000,5000);
        TimeUnit.SECONDS.sleep(10);
        timer.cancel();
        System.out.println("Timer is cancelled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("prodAll");
        Task.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("over");
        es.shutdownNow();
    }
}

class Blocker{
    synchronized void waitingForCall(){
        try{
            while (!Thread.interrupted()){
                System.out.println(Thread.currentThread()+"is waiting for call");
                wait();
                System.out.println(Thread.currentThread()+"is running");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    synchronized void prod(){notify();}
    synchronized void prodAll(){notifyAll();}
}

class Task implements Runnable{
    static Blocker blocker = new Blocker();
    public void run() {
        blocker.waitingForCall();
    }
}
 class Task2 implements Runnable{
     static Blocker blocker = new Blocker();
     public void run() {
         blocker.waitingForCall();
     }
 }
