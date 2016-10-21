package song.EnumTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * Created by Song on 2016/10/18.
 */
enum WEEKDAY  {
    MONDAY("This is the First Day of the week"),
    TUESDAY("This is the Second Day"),
    WEDNSDAY("This is the Third Day"),
    THURSDAY("This is the Forth Day"),
    FRIDAY("This is the Fifth Day"),
    SATURDAY("This is the Sixth Day"),
    SUNDAY("this is the Seventh Day");

    private String description;
    private WEEKDAY(String des){
        this.description = des;
    }
    public String getDescripiton(){
        return this.description;
    }
}
public class EnumClass {
    public static void main(String [] args){
        for (WEEKDAY w:WEEKDAY.values()) {
            System.out.println(w+" --> "+w.ordinal()+" : "+w.getDeclaringClass());
        }
        Method [] fields = WEEKDAY.class.getMethods();
        for (Method m:fields) {
            System.out.println(m.getName());
        }
        for(WEEKDAY w:WEEKDAY.values()){
            System.out.println(w.getDescripiton());
        }
        for(int i=0;i<10;i++){
            System.out.println(randomEnum(WEEKDAY.class));
        }
    }

    public static <T extends Enum<T>>T randomEnum(Class<T> ec){
        Random random = new Random();
        T [] enums = ec.getEnumConstants();
        return enums[random.nextInt(enums.length)];
    }
}
