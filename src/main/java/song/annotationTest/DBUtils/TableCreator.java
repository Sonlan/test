package song.annotationTest.DBUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Song on 2016/10/25.
 * DB 注解处理器
 */
public class TableCreator {
    public static void main(String [] args){
            Member member = new Member("Song","PF",23,"ADMIN");
            List<String> list = new ArrayList<String>();
            Class memberClass = member.getClass();
            if(null !=memberClass.getAnnotation(DBTable.class)){
                Field [] fields = memberClass.getDeclaredFields();
                for (Field f:fields){
                    Annotation [] annotations = f.getDeclaredAnnotations();
                    if(1>annotations.length){
                        continue;
                    }
                    for (Annotation a:annotations) {
                        list.add(f.getName()+" "+AnnotationHandler.handler(a));
                    }

                }
                for(String str:list){
                    System.out.println(str);
                }
            }
    }
}

class AnnotationHandler{
    public static String handler(Annotation a){
        if(a instanceof Constraints) return handler((Constraints) a);
        if(a instanceof SQLInteger) return handler((SQLInteger) a);
        if(a instanceof SQLString) return handler((SQLString) a);
        return "";
    }
    public static String handler(Constraints c){
        return " alowNull "+c.allowNull()+" unique "+c.unique()+" primaryKey "+c.primaryKey();
    }
    public static String handler(SQLInteger s){
        return " Integer name "+s.name()+handler(s.constraints());
    }
    public static String handler(SQLString s){
        return " String name "+s.name()+" value "+s.value()+handler(s.constraints());
    }
}
