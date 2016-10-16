import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Song on 2016/7/29.
 */
public class LeetCode {
    private static int value = 2;

    public static void main(String [] args){
        LeetCode lc = new LeetCode();
        long start = System.currentTimeMillis();
        try{
            System.out.println(lc.isMatch("aabc","a*bc"));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("time:"+(System.currentTimeMillis()-start));
    }
    //获得中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int temp2=0;  //记录nums2中的上次插入位置
        ArrayList<Integer> res = new ArrayList<Integer>();
        //将nums1向nums2中插入
        for(int i=0;i<len1;i++){
            for(int j=temp2;j<len2;j++){
                if(nums1[i]<nums2[j]) {
                    res.add(nums1[i]);
                    temp2=j;
                    break;
                }else{
                    res.add(nums2[j]);
                    if(j>=len2-1) {
                        temp2 = len2;
                    }
                }
            }
            if(temp2>=len2){
                res.add(nums1[i]);
            }
        }
        if(temp2<len2){//nums2中还有元素未被插入
            for(int i=temp2;i<len2;i++){
                res.add(nums2[i]);
            }
        }
        if(0==(len1+len2)%2)
            return (res.get((len1+len2)/2-1)+res.get((len1+len2)/2))/2.0;
        else
            return res.get((len1+len2)/2);
    }
    //检测最长回文字符串,奇对称额偶对称
/*
    public String longestPalindrome(String s) {
        int low =0;
        int up =0;
        int begin=0,end=0;
        int begins=0,ends=0;
        int length=0==s.length()?0:1;
        int flag = 0;
        for(int i=0;i<s.length();i++) {
            flag = 0;
            while (2>flag) {
                up = i + 1;
                if (0 == flag) {
                    low = i;
                } else {
                    low = i - 1;
                }
                while (0 <= low && s.length() > up) {
                    if (s.charAt(low) != s.charAt(up)) {
                        break;
                    }
                    begin=low;
                    end = up;
                    low--;
                    up++;
                }
                if (length < (end-begin+1)) {
                    begins=begin;
                    ends= end;
                    length = ends-begins+1;
                }
                flag++;
            }
        }
        return s.substring(begins,ends+1);
    }
*/
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

/*    public String convert(String s, int numRows) {
        char [][] strs = new char[numRows][100];
        int row = 0,col=0;
        boolean isup = false;
        for (char c:s.toCharArray()) {
            strs[0][0]='a';
            strs[row][col]=c;
            if(row>=numRows-1){
                isup=true;
            }else if(row<=0){
                isup=false;
            }
            if(!isup){
                row++;
            }else{
                row--;
                col++;
            }
        }
        return strs.toString();
    }*/
    public String convert(String s, int numRows) {
        if(1>=numRows || numRows>=s.length()) return s;
        String res = "";
        List<Integer>up = new ArrayList<Integer>();
        int index0=0,len=s.length();
        int i=0;
        int left = 0, right=0;
        while(len>index0){
            if(len>index0)
                up.add(index0);
            i++;
            index0 = 2*(numRows-1)*i;
        }
        //多增加一个额外顶点（越界），保证所有点都被包括进去了
        up.add(index0);
        i=0;
        while(i<numRows){
            for(int point:up){
                if(0==i) {
                    if(point>=0 && point<len)
                        res += s.charAt(point);
                    continue;
                }
                if(numRows-1>i) {
                    left = point - i;
                    right = point + i;
                    if (left >= 0 && left < len)
                        res += s.charAt(left);
                    if (right >= 0 && right < len)
                        res += s.charAt(right);
                }else{
                    right = point + i;
                    if (right >= 0 && right < len)
                        res += s.charAt(right);
                }
            }
            i++;
        }

        return res;
    }
    public int reverse(int x) {
        boolean isUpZero = x>=0?true:false;
        double res = 0;
        char [] strs = (Math.abs(x)+"").toCharArray();

        for(int i=strs.length-1;i>=0;i--){
            res+=Integer.parseInt(strs[i]+"")*Math.pow(10,i);
        }
        if(res<=Integer.MIN_VALUE || res>=Integer.MAX_VALUE) return 0;
        return isUpZero?(int)res:-(int)res;
    }
    /*public int myAtoi(String str) {
        try{
            String regx = "([+-]?\\d*)(.*?)";
            Pattern pattern = Pattern.compile(regx);
            Matcher mather = pattern.matcher(str.trim());
            while(mather.find()){
                long res = Long.parseLong(mather.group(1));
                if(res>Integer.MAX_VALUE ) return Integer.MAX_VALUE;
                if(res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
                return (int)res;
            }
            return 0;
        }catch(Exception e){
            return 0;
        }
    }*/
    public int myAtoi(String str) {
        try{
            String str1 = str.trim();
            int i = 0;
            for(i=0;i<str1.length();i++){
                if(0==i){
                    if(!(('+'==str1.charAt(i)||'-'==str1.charAt(i))||('0'<=str1.charAt(i)&&'9'>=str1.charAt(i))))
                        return 0;
                }else{
                    if('0'>str1.charAt(i)||'9'<str1.charAt(i))
                        break;
                }
            }
            if(i>11) return '-'==str1.charAt(0)?Integer.MIN_VALUE:Integer.MAX_VALUE;
            long res = Long.parseLong(str1.substring(0,i));
            if(res>Integer.MAX_VALUE ) return Integer.MAX_VALUE;
            if(res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return (int)res;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public boolean isMatch(String s, String p) {
        int m = 0;  //记录s已经匹配成功的位置
        int j=0,temp=0;
        for(int i=0;i<p.length();i++){
            for(j=temp;j<s.length();j++){
                if('.'==p.charAt(i)){
                    temp++;
                    m=j;
                    break;
                }else if('*'==p.charAt(i)){
                    if(i-1>=0 && i-1<p.length()){
                        if('.'==p.charAt(i-1)){
                            if(i==p.length()-1)//最后一个
                                return true;
                            else {
                                //TO-DO
                            }
                        }
                        if(s.charAt(j)!=p.charAt(i-1)) {
                            temp=j;
                            break;
                        }
                        m=j;
                    }
                }else{
                    if(s.charAt(j)==p.charAt(i)){
                        m=j;
                        temp++;
                        break;
                    }else{
                        if(i+1<p.length()){
                            if('*'==p.charAt(i+1)){
                                break;
                            }
                        }
                        return false;
                    }
                }

            }
        }
        if(m<s.length()-1) return false;
        return true;
    }
}
