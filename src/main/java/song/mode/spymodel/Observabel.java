package song.mode.spymodel;

/**
 * Created by Song on 2016/8/30.
 * 被监管接口
 */
public interface Observabel {
     void addObserver(Observer observer);
     void removeObserver(Observer observer);
     void notifyAllObservers(String context);
}
