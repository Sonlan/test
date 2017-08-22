package song.wangyi.intern;

import java.util.*;

/**
 * Created by Song on 2017/8/12.
 * 小易非常喜欢拥有以下性质的数列:
 1、数列的长度为n
 2、数列中的每个数都在1到k之间(包括1和k)
 3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可)
 例如,当n = 4, k = 7
 那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
 但是小易不喜欢{4,4,4,2}这个数列。小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。
 */
public class Main3 {
    private static int total=0;
    //递归超时,而采用map记录对于i结尾的符合要求的j，则超内存
/*    public static int process(int n,int k){
        if(n<=0) return 0;
        if(k<=1) return 1;
        if(n==1) return k;
        for(int i=1;i<=k;i++){
            core(n, k, i, 2);
        }
        return total;
    }

    public static void core(int n,int k,int a,int count){
        if(count > n) {
            total++;return;
        }
        for (int i = 1; i <= k; i++) {
            if ((i >= a || a % i != 0)) {
                core(n, k, i, count+1);
            }
        }
    }*/

    public static int [] toInt(String [] args){
        int [] result = new int[args.length];
        int i=0;
        for(String val:args){
            result[i++] = Integer.parseInt(val);
        }
        return result;
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String args1 = scanner.nextLine();
        int [] args2 = toInt(args1.split(" "));
        System.out.println(process(args2[0],args2[1]));
    }

    //动态规划，dp[i][j]标识长度为i且以数字j结尾的序列的个数，则dp[i][j] = sum(dp[i-1][m]),其中(m,j)满足序列要求
    public static int process(int n,int k){
        int [][] dp = new int[n+1][k+1];
        int sum;
        //dp[0][],dp[][0]初始化为0
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<k+1;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<n+1;i++){
            //对于j,求取sum(dp[i-1][m]) (A <= B)或(A mod B != 0),避免嵌套循环，提到内循环外，只减除不符合要求的部分
            sum=0;
            for(int p=1;p<=k;p++){
                sum+=dp[i-1][p];
            }
            for(int j=1;j<k+1;j++){
                //计算sum中不符合要求的部分
                int q = 2,invalid=0;
                while (q*j <= k){
                    invalid+=dp[i-1][q*j];
                    q++;
                }
                dp[i][j] = sum - invalid;
            }
        }
        sum=0;
        for(int j=1;j<=k;j++){
            sum+=dp[n][j];
        }
        return sum%1000000007;
    }
}
