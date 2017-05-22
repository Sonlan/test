package song.basis.threadTest.ThreadLocalTest;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Song on 2016/10/15.
 */
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> values = new ThreadLocal<Integer>(){
      private Random rand = new Random(47);
      @Override
      protected synchronized Integer initialValue() {
          return rand.nextInt(10000);
      }
    };
    public static void increment(){
        values.set(values.get()+1);
    }
    public static int get(){return values.get();}

    public static void main(String [] args) throws InterruptedException{
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            es.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(5);
        es.shutdown();
    }
}

class Accessor implements Runnable{
    private final  int id;
    public Accessor(int id){this.id=id;}
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted()){
            count++;
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            if(count>=5)
                break;
            Thread.yield();
        }
    }
    public String toString(){
        return "#"+id+": "+ThreadLocalVariableHolder.get();
    }
}

