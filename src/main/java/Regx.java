import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式
 * Created by Song on 2016/7/23.
 */
public class Regx {
    public String regx(String regx){
        return "";
    }

    public static void main(String [] args){
        String str = "Aabchd eDf 164 sd123 AD";
        String regx = "[^A-Z]\\w+";
        Pattern pattern  = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str);

       while(matcher.find()){
           System.out.println(matcher.group());
       }


    }
}
