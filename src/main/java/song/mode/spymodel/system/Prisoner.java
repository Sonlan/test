package song.mode.spymodel.system;

import java.util.Observable;

/**
 * Created by Song on 2016/8/31.
 */
public class Prisoner extends Observable{
    public void run(){
        System.out.println("我要逃跑了");
        super.setChanged();
        super.notifyObservers("囚犯要逃跑了");
    }
}
