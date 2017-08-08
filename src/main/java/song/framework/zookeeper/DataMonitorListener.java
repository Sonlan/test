package song.framework.zookeeper;

/**
 * Created by Song on 2017/8/3.
 */
public interface DataMonitorListener {
    /**
     * The existence status of the node has changed.
     */
    void exists(byte data[]);

    /**
     * The ZooKeeper session is no longer valid.
     *
     * @param rc
     * the ZooKeeper reason code
     */
    void closing(int rc);
}
