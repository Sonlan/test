package song.basis.InnerClassTest;

/**
 * Created by Song on 2016/10/7.
 */
public class ConcreteClass extends OuterClass {
    public class InnerClass{
        void test(){
            System.out.println("2.test()");
        }
    }


    public static void main(String [] args){
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.print();
    }
}
