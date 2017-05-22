package song.basis.InnerClassTest;

/**
 * Created by Song on 2016/10/6.
 */
public class OuterClass {
    private int i=0;
    protected class InnerClass{
        void test(){
            System.out.println("1.test()");
        }
    }
    public void print(){
        this.new InnerClass().test();
    }

    public void print1(){
        print();
    }
}
