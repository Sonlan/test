package song.questionbank.leetcode_niuke;

import java.util.ArrayList;

/**
 * Created by Song on 2017/8/17.
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 For example,
 If n = 4 and k = 2, a solution is:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
//当时没思路，看解析，回溯法,其实就是递归，看看想想有好处，对比全排列，可以延伸到定长的全排列（只需要多一个交换即可，想想为什么）
public class Solution72 {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(n<1 || k<1) return result;
        if(n < k) return result;
        backTrace(n,k,1,new ArrayList<Integer>(),result);
        return result;
    }

    public void backTrace(int n,int k,int index,ArrayList<Integer> curList,ArrayList<ArrayList<Integer>> result){
        if(curList.size()>=k){
            result.add(new ArrayList<>(curList));return;
        }
        for(int i = index;i<=n;i++){
            curList.add(i);
            //对比71题里面全排列传入的参数index+1，这里是i+1，也就是包含的范围不同
            backTrace(n, k, i+1, curList, result);
            curList.remove(curList.size()-1);
        }
    }

    public static void main(String [] args){
        Solution72 sol = new Solution72();
        System.out.println(sol.combine(4,2));
    }
}
