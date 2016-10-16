package song.ExceptionTest;

/**
 * Created by Song on 2016/10/9.
 */
public class ExceptionTest {
    public static void main(String [] args){
        try{
            new ExceptionTest().test();
        }catch (MyException e){
            e.printStackTrace();
        }
    }

    public void test() throws MyException{
        throw new MyException("异常测试");
    }
}
