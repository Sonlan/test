package song.EnumTest;

/**
 * Created by Song on 2016/10/18.
 */
enum WEEKDAY  {MONDAY,TUESDAY,WEDNSDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY}
public class EnumClass {
    public static void main(String [] args){
        for (WEEKDAY w:WEEKDAY.values()) {
            System.out.println(w+" --> "+w.ordinal()+" : "+w.getDeclaringClass());
        }
    }
}
