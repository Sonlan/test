package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/14.
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution53 {
    public boolean isNumeric(char[] str) {
        if(null == str || str.length ==0) return false;
        int start = 0;
        //是否出现e
        boolean eFlag = false;
        boolean pointFlag = false;
        if(str[0] == '+' || str[0] == '-'){
            if(str.length<2) return false;
            start = 1;
        }
        for(int i=start;i<str.length;i++){
            if(str[i]=='e' || str[i] == 'E'){
                if(eFlag || i >=str.length-1) return false;
                eFlag = true;
                if(str[i+1] == '+' || str[i+1] == '-') {
                    if(i+1 >= str.length-1) return false;
                    i++;
                }
                continue;
            }
            if(eFlag){
                if(str[i]>'9' || str[i]<'0') return false;
            }else {
                if(str[i]=='.'){
                    if(pointFlag || i==0) return false;
                    pointFlag = true;
                    continue;
                }
                if(str[i]>'9' || str[i]<'0') return false;
            }
        }
        return true;
    }

    public static void main(String [] args){
        System.out.println(new Solution53().isNumeric(new String("5e2").toCharArray()));
    }
}
