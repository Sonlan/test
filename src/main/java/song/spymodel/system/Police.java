package song.spymodel.system;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Song on 2016/8/31.
 */
public class Police implements Observer {
    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    public void update(Observable o, Object arg) {
        System.out.println("警察发现"+arg.toString());
    }
}
