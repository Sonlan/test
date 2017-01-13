package song.annotationTest.DBUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Song on 2016/10/25.
 * VARCHAR类型
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
    int value() default 0;  //长度
    String name() default "";  //键值
    Constraints constraints() default @Constraints;
}
