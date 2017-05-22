package song.basis.threadTest;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by Song on 2016/10/11.
 * 有泛型返回值的并发任务
 */
public class CallbackInstance implements Callable<String> {
    private  int i=0;
    public CallbackInstance(int i){
        this.i = i;
    }
    public String call() throws Exception {
        Random random = new Random();
        int delay = Math.abs(random.nextInt(5000));
        Thread.sleep(delay);
        return "this is task of "+this.i+". And its delay is "+delay+" ms, its thread id is "+Thread.currentThread().getId();
    }
}
