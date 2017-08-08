package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/8.
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 For example,
 Given n = 3, there are a total of 5 unique BST's.
 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
//参考上一题的思路很简单，再尝试以动态规划的方式做一下
public class Solution54 {
/*    //32ms 8660k
    public int numTrees(int n) {
        if(n<1) return 0;
        return numTreesCore(1,n);
    }

    public int numTreesCore(int low,int high){
        if(low >= high) return 1;
        int total=0;
        for(int i=low;i<=high;i++){
            int left = numTreesCore(low,i-1);
            int right = numTreesCore(i+1,high);
            total+=left*right;
        }
        return total;
    }*/
    //动态规划,14ms,8504k,两种形式，一种是去递归（没想出来，应该是单方向增长才行，这个是双向的）,一种是保留递归形式，只是保存中间计算结果
    public int numTrees1(int n) {
        if(n<1) return 0;
        int [][] dp= new int[n][n];
        return numTreesCore1(1,n,dp);
    }
    public int numTreesCore1(int low,int high,int [][] dp){
        if(low >= high) {return 1;}
        if(dp[low-1][high-1]!=0) return dp[low-1][high-1];
        int total=0;
        for(int i=low;i<=high;i++){
            int left = numTreesCore1(low,i-1,dp);
            int right = numTreesCore1(i+1,high,dp);
            total+=left*right;
        }
        dp[low-1][high-1] = total;
        return total;
    }

    public static void main(String [] args){
        Solution54 sol = new Solution54();
        System.out.println(sol.numTrees1(3));
    }
}
