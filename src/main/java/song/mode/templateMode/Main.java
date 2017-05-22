package song.mode.templateMode;

/**
 * Created by Song on 2016/9/6.
 * 测试类
 */
public class Main {
    public static void main(String [] args){
        //中国人的吃饭方式
        System.out.println("中国人吃饭过程：");
        AbstractClass chinese = new ConcreteClass1();
        chinese.templateMethod();
        //西方人的吃饭方式
        System.out.println("西方人吃饭过程：");
        AbstractClass foreigner = new ConcreteClass2();
        foreigner.templateMethod();
    }
}
