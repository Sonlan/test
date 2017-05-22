package song.mode.spymodel;

/**
 * Created by Song on 2016/8/30.
 * 监管类
 */
public class Police implements Observer {
    public void update(String txt) {
        System.out.println("Police 发现"+txt);
    }
}
