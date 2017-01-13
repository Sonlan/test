import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Song on 2016/8/24.
 */
public class HashCode {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = " ";
        File file = new File("D:\\Software\\apache-tomcat-6.0.45\\webapps\\manage\\static\\file/7/0");
        file.mkdirs();
        while(!"".equals(str)){
            str = br.readLine();
            int code = str.hashCode();
            System.out.println(code+"  "+(code&0x0f)+"  "+((code&0x00f0)>>4)+"  "+Integer.toHexString(code));
        }
    }
}
