package song.threadTest.ThreadEndTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Song on 2016/10/18.
 */
public class ThreadInterruptTest {
    public static void main(String [] args) throws Exception{
        ExecutorService es = Executors.newCachedThreadPool();
        //ServerSocket ss = new ServerSocket(8080);
        //InputStream in = new Socket("localhost",8080).getInputStream();
        InputStream in = System.in;
        es.execute(new IOBlocked(in));
        TimeUnit.SECONDS.sleep(1);
        es.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        in.close();
/*        InputStream in = System.in;
        Thread t = new Thread(new IOBlocked(in));
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(t.getState());
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.getState());
        System.out.println(t.isInterrupted());
        in.close();
        System.out.println(t.getState());
        System.out.println(t.isInterrupted());*/
    }

}
class IOBlocked implements Runnable{
    private InputStream in;
    public IOBlocked(InputStream in){this.in = in;}
    public void run() {
        try {
                System.out.println("start");
                in.read();
                System.out.println("end");
        }catch (IOException e){
            System.out.println("IOException");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally end");
        }
    }
}
