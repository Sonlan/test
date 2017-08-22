package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/9.
 * A message containing letters fromA-Zis being encoded to numbers using the following mapping:
 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.
 For example,
 Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
 The number of ways decoding"12"is 2.
 */
//动态规划，i位置的次数等于i-1位置的次数+i-2位置的次数（如果i-1,i两处字符成立的话）
public class Solution59 {
    public int numDecodings(String s) {
        if(null ==s || 0==s.length() || s.charAt(0) == '0' ) return 0;
        int [] count = new int[s.length()];
        count[0]=1;
        for(int i=1;i<s.length();i++){
            if(valid(s.substring(i,i+1))) {
                count[i] += count[i - 1];
            }
            if(valid(s.substring(i-1,i+1))){
                if(i==1){
                    count[i]+=1;
                }else count[i]+=count[i-2];
            }
        }
        return count[s.length()-1];
    }

    public boolean valid(String s){
        if(s.length()>1 && s.charAt(0) == '0') return false;
        int itn = Integer.parseInt(s);
        if(itn>26 || itn <=0) return false;
        return true;
    }

    public static void main(String [] args){
        Solution59 sol = new Solution59();
        System.out.println(sol.numDecodings("101"));
    }

}
