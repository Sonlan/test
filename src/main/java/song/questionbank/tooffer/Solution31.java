package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/9.
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数
 *
 * 思路参考：http://www.cnblogs.com/nailperry/p/4752987.html
 */
public class Solution31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n == 0) return 0;
        //总数
        int total = 0;
        int index = 1;
        //高位
        int high = n;
        //当前位置
        int curPos;
        //低位
        int low;
        int tmp;
        while ( n >= Math.pow(10,index-1) ){
            high = n/(int)(Math.pow(10,index));
            tmp = n%(int)(Math.pow(10,index));
            curPos = tmp/(int) (Math.pow(10,index-1));
            low = tmp%(int)Math.pow(10,index-1);
            if(curPos>1){
                total+=(high+1)*Math.pow(10,index-1);
            }else if(curPos==1){
                total+=high*Math.pow(10,index-1)+low+1;
            }else{
                total+=high*Math.pow(10,index-1);
            }
            index++;
        }
        return total;
    }

    public static void main(String [] args){
        System.out.println(new Solution31().NumberOf1Between1AndN_Solution(55));
    }
}
