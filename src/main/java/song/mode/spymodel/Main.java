package song.mode.spymodel;

/**
 * Created by Song on 2016/8/30.
 */
public class Main {
    public static void main(String [] args){
        Police police = new Police();
        Officer officer = new Officer();
        Prisoner prisoner = new Prisoner();

        prisoner.addObserver(police);
        prisoner.addObserver(officer);

        prisoner.run();
    }
}
