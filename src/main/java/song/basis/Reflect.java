package song.basis;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * java 反射机制测试
 * Created by Song on 2016/8/5.
 */
public class Reflect {
    public static void main(String [] args){
        try{
            Test test = new Test();
            Class c1 = test.getClass();
            Field [] fields = c1.getDeclaredFields();
            Method [] methods = c1.getDeclaredMethods();
            System.out.println(fields.toString());
            Test test1 = (Test) c1.newInstance();
            Method method = c1.getDeclaredMethod("test1",String.class,int.class);
            method.setAccessible(true);
            method.invoke(test1,"test str",10);
            System.out.println(method.getModifiers());
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }
    }

}
class Test{
    private int a;

    public String b;

    private void test1(String s, int i){
        System.out.println(s+"   "+i);
    }
    protected String test2(String test){
        return test;
    }
}
