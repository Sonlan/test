import java.util.Date;

/**
 * Created by Song on 2016/8/29.
 * 自增长测试
 */
public class Main{
    public static void main (String [] args) {
        String temp = "";
        StringBuffer strBuffer ;
        for(int i=0;i<10;i++){
            temp=i+"";
            strBuffer = new StringBuffer(i+"");
            System.out.println(strBuffer.hashCode());
            System.out.println(temp.hashCode());
        }
    }
}
