package song.framework.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * Created by Song on 2017/8/3.
 */
public class Executor implements Watcher,Runnable,DataMonitorListener{
    private ZooKeeper zk;

    public void process(WatchedEvent watchedEvent) {

    }

    public void run() {

    }

    public void exists(byte[] data) {

    }

    public void closing(int rc) {

    }
}
