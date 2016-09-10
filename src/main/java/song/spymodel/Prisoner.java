package song.spymodel;

import java.util.ArrayList;

/**
 * Created by Song on 2016/8/30.
 * 被监控类
 */
public class Prisoner implements Observabel{
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyAllObservers(String context) {
        for (Observer obs:this.observers) {
            obs.update(context);
        }
    }

    public void run(){
        System.out.println("囚犯：我要偷偷逃跑");
        this.notifyAllObservers("囚犯要逃跑啦");
    }
}
