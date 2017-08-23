package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/22.
 * Validate if a given string is numeric.
 Some examples:
 "0"=>true
 " 0.1 "=>true
 "abc"=>false
 "1 a"=>false
 "2e10"=>true
 Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
//无学习价值，反复试样例
public class Solution83 {
    public boolean isNumber(String s) {
        s = s.trim();
        String [] source = s.split("e");
        if(source.length>2 || source.length==0|| 0==source[0].length() || 'e' == s.charAt(s.length()-1) || 'e' == s.charAt(0)) return false;
        if(source[0].equals(".") || source[0].equals("-") || source[0].equals("+")
                || source[0].equals("+.") || source[0].equals("-.")) return false;
        boolean pFlag = false;
        for(int i=0;i<source[0].length();i++){
            char c = source[0].charAt(i);
            if(isNum(c)) continue;
            else if(c == '.'){
                if(pFlag) return false;
                pFlag = true;
            }else if((c =='-' || c== '+' )&& i ==0) {
                if(source[0].length()>=2 && isNum(source[0].charAt(i+1)))
                continue;
            }else return false;
        }
        if(source.length ==2){
            if(source[1].equals("-") || source[1].equals("+") ) return false;
            for(int i=0;i<source[1].length();i++){
                char c = source[1].charAt(i);
                if(isNum(c)){
                    continue;
                }else if((c =='-' || c== '+' ) && i ==0) {
                    continue;
                }else return false;
            }
        }
        return true;
    }

    public boolean isNum(char c){
        if(c > '9' || c < '0') return false;
        return true;
    }

    public static void main(String [] args){
        Solution83 sol = new Solution83();
        System.out.println(sol.isNumber(" "));
    }


}
