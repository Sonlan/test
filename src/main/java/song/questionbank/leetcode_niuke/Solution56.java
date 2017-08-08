package song.questionbank.leetcode_niuke;

import java.util.ArrayList;

/**
 * Created by Song on 2017/8/8.
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 For example:
 Given"25525511135",
 return["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Solution56 {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if(s.length()>12) return result;
        restoreIpAddressesCore(s,0,"",0,result);
        return result;
    }

    public void restoreIpAddressesCore(String s,int start,String curStr,int count,ArrayList<String> result){
        if(start>=s.length() && count == 4){
            result.add(curStr.substring(0,curStr.length()-1));return;
        }
        if(start>=s.length()) return;
        for(int i=start+1;i<=s.length();i++){
            if(isValidIPPart(s.substring(start,i))){
                restoreIpAddressesCore(s, i, curStr+s.substring(start,i)+".", count+1, result);
            }
        }
    }

    public boolean isValidIPPart(String s){
        if(null ==s || s.length()>3 || s.length()<1 || Integer.parseInt(s)>255 || (s.length()>1 && s.charAt(0)=='0')) return false;
        return true;
    }

    public static void main(String [] args){
        Solution56 sol = new Solution56();
        System.out.println(sol.restoreIpAddresses("010010"));
    }
}
