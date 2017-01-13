package song.spymodel.system;

/**
 * Created by Song on 2016/8/31.
 */
public class Main {
    public static void main(String args[]){
        Police police = new Police();
        Prisoner prisoner = new Prisoner();
        prisoner.addObserver(police);
        prisoner.run();
    }
}
