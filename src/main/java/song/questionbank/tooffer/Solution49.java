package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/13.
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class Solution49 {
    public int StrToInt(String str) {
        if(null == str || 0>= str.length()) return 0;
        char fc = str.charAt(0);
        if(fc == '+'){
            if(str.length()>1)
                return StrToIntCore(str.substring(1));
            return 0;
        }
        if(fc == '-' ){
            if(str.length()>1)
                 return -StrToIntCore(str.substring(1));
            else return 0;
        }
        return StrToIntCore(str);
    }

    private int StrToIntCore(String str){
        if(null == str || 0>= str.length()) return 0;
        int len = str.length();
        int result = 0;
        char c;
        for(int i=0;i<str.length();i++){
            c = str.charAt(i);
            if(c > '9' || c < '0') return 0;
            result = result*10+(c-'0');
            //result+=(c-'0')*Math.pow(10,len-i-1);  //这种情况-2147483648溢出只能显示-2147483647，不知道原因
        }
        return result;
    }

    public static void main(String [] args){
        System.out.println(new Solution49().StrToInt("-2147483648"));
    }
}
