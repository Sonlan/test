package song.questionbank.tooffer;

/**
 * 重点理解一下逻辑
 * Created by Song on 2017/6/14.
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution52 {
    /*public boolean match(char[] str, char[] pattern)
    {
        int i = 0,j=0;
        while (i<str.length && j<pattern.length){
            if(str[i]==pattern[j]){
                i++;j++;continue;
            }else{
                if(pattern[j]=='.'){
                    i++;j++;continue;
                }else if(pattern[j]=='*'){
                    if(pattern[j-1] == str[i] || pattern[j-1]=='.'){
                        //寻找下一个不同点
                        while ((++i)<str.length){
                            if(str[i]!=str[i-1]){
                                if(str[i]!= pattern[j+1]){

                                }
                            }
                        }
                    }
                }else if(pattern[j+1]=='*'){

                }
            }
        }
    }*/
    public boolean match(char[] str, char[] pattern) {
        if(null == str || null == pattern) return false;
        return matchCore(str,0,pattern,0);
    }

    public boolean matchCore(char[] str, int strStart,char [] pattern,int patStart){
        if(strStart>= str.length && patStart>= pattern.length) return true;
        if(strStart<str.length && patStart >= pattern.length) return false;

        if(patStart+1 < pattern.length && pattern[patStart+1]=='*'){
            //匹配的情况.* 或x*
            if(strStart<str.length && (str[strStart]==pattern[patStart] || patStart<pattern.length && pattern[patStart]=='.')){
                return matchCore(str, strStart+1, pattern, patStart)
                        || matchCore(str, strStart+1, pattern, patStart+2)
                        || matchCore(str, strStart, pattern, patStart+2);
            }else{
                return matchCore(str, strStart, pattern, patStart+2);
            }
        }

        if(strStart<str.length && (str[strStart] == pattern[patStart] || pattern[patStart] == '.')){
            return matchCore(str, strStart+1, pattern, patStart+1);
        }
        return false;
    }

    public static void main(String [] args){
        System.out.println(new Solution52().match(new String("").toCharArray(),new String(".").toCharArray()));
    }
}
