package song.framework.jeromq.version;

import org.zeromq.ZMQ;

/**
 * Created by Song on 2017/1/12.
 * 查看zeromq的最新版本
 */
public class Version {
    public static void main (String[] args) {
        System.out.println(String.format("Version string: %s, Version int: %d",
                ZMQ.getVersionString(),
                ZMQ.getFullVersion()));
    }
}
