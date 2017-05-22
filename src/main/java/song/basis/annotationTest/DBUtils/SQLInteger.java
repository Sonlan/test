package song.basis.annotationTest.DBUtils;

/**
 * Created by Song on 2016/10/25.
 * 整形
 */
public @interface SQLInteger {
    String name() default "";
    Constraints constraints() default @Constraints;
}
