package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/23.
 * Given two binary strings, return their sum (also a binary string).
 For example,
 a ="11"
 b ="1"
 Return"100".
 */
public class Solution84 {
    public String addBinary(String a, String b) {
        if(null == a || null == b) return null;
        int i=a.length()-1,j=b.length()-1;
        char flag = 0;
        int res;
        StringBuilder sb = new StringBuilder();
        while (i>=0 && j>=0){
            if(i == a.length()-1 && j == b.length() -1) {
                res = a.charAt(i) + b.charAt(j) - '0' * 2;
                if (res == 2) {
                    sb.insert(0, 0);
                    flag = '1';
                }else {
                    sb.insert(0, res);
                    flag = '0';
                }
            }else{
                res = a.charAt(i) + b.charAt(j) + flag - '0' * 3;
                if (res >= 2) {
                    sb.insert(0, res-2);
                    flag ='1';
                }else{
                    sb.insert(0, res);
                    flag = '0';
                }
            }
            i--;j--;
        }
        while (i>=0){
            res = a.charAt(i) + flag - '0'*2;
            if (res >= 2) {
                sb.insert(0, res-2);
                flag ='1';
            }else{
                sb.insert(0, res);
                flag = '0';
            }
            i--;
        }
        while (j>=0){
            res = b.charAt(j) + flag - '0'*2;
            if (res >= 2) {
                sb.insert(0, res-2);
                flag ='1';
            }else{
                sb.insert(0, res);
                flag = '0';
            }
            j--;
        }
        if(flag == '1') sb.insert(0,1);
        return sb.toString();
    }

    public static void main(String [] args){
        Solution84 sol = new Solution84();
        System.out.println(sol.addBinary("11","1"));
    }


}
