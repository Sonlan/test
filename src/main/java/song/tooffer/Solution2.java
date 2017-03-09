package song.tooffer;

/**
 * Created by Administrator on 2017/3/3.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }
    public static void main(String [] args){
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.replaceSpace(new StringBuffer("I am a good boy")));
    }
}
