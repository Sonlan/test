package song.annotationTest.DBUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Song on 2016/10/25.
 * 字段约束内容
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    boolean primaryKey() default false; //主键
    boolean allowNull() default false; //是否允许NULL
    boolean unique() default false;  //是否唯一
}
