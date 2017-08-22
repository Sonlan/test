package song.questionbank.leetcode_niuke;

import java.util.ArrayList;

/**
 * Created by Song on 2017/8/9.
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 For example, given n = 2, return[0,1,3,2]. Its gray code sequence is:
 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.
 For example,[0,2,3,1]is also a valid gray code sequence according to the above definition.
 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
//着重思想，n bit的数字序列，先写n-1 bit的序列，做镜像对称，然后前面分别加0，和1即可得到n bit的灰码序列，所以得从1bit开始推
//理解记住，https://www.nowcoder.com/profile/878487/codeBookDetail?submissionId=10998061
public class Solution60 {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        if(n<1) return res;
        res.add(0);
        int curSize;
        for(int i=0;i<n;i++){
            curSize = res.size();
            //倒序
            for(int j=curSize-1;j>=0;j--){
                //把最高位置为1
                res.add((1<<(i))|res.get(j));
            }
        }
        return res;
    }

    public static void main(String [] args){
        Solution60 sol = new Solution60();
        System.out.println(sol.grayCode(3));
    }
}
