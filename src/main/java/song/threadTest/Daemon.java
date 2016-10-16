package song.threadTest;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Song on 2016/10/12.
 */
public class Daemon implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);//后台线程
        return null;
    }
}
