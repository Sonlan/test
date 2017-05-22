package song.mode.spymodel;

/**
 * Created by Song on 2016/8/30.
 */
public class Officer implements Observer{
    public void update(String txt) {
        System.out.println("Officer 发现"+txt);
    }
}
