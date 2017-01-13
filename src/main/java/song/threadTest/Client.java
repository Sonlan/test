package song.threadTest;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Song on 2016/10/11.
 */
public class Client {
    public static void main(String [] args) throws InterruptedException,ExecutionException{
        ArrayList<Future<String>> list = new ArrayList<Future<String>>();
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0;i<100;i++){
            //list.add(executor.submit(new CallbackInstance(i)));  //有返回值的并发任务
            executor.execute(LiftOff.getInstance());
        }
        LiftOff.getInstance().test();
/*        while(0!=list.size()) {
            for (Future<String> f : list) {
                if (f.isDone()) {
                    System.out.println(f.get());
                    list.remove(f);
                    break;
                }
            }
        }*/
        executor.shutdown();
    }
}
