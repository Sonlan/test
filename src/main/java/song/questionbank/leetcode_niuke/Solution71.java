package song.questionbank.leetcode_niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Song on 2017/8/16.
 * Given a set of distinct integers, S, return all possible subsets.
 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.

 For example,
 If S =[1,2,3], a solution is:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Solution71 {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(S);
        subsetsCore1(S,0,result,new ArrayList<>());
        sort(result);
        return result;
    }
    //全排列
    public void subsetsCore(int [] S,int index,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> curList){
        if(index>=S.length) {
            result.add(new ArrayList<>(curList));return;
        }
        for(int i = index;i<S.length;i++){
            swap(S,index,i);
            curList.add(S[index]);
            subsetsCore(S,index+1,result,curList);
            swap(S,i,index);curList.remove(curList.size()-1);
        }
    }

    public void swap(int [] S,int i,int j){
        int temp = S[i];
        S[i] = S[j];
        S[j] = temp;
    }
    //子集
    public void subsetsCore1(int [] S,int index,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> curList){
        if(index>=S.length) {
            result.add(new ArrayList<>(curList));return;
        }
        curList = new ArrayList<>(curList);
        subsetsCore1(S, index+1, result, curList);
        curList.add(S[index]);
        subsetsCore1(S, index+1, result, curList);
    }

    public void sort(ArrayList<ArrayList<Integer>> result){
        if(null == result || 1>= result.size()) return ;
        int j;
        for (int i=1;i<result.size();i++){
            ArrayList<Integer> tmp = result.get(i);
            for( j=i;j>0 && coparator(tmp,result.get(j-1),0)<0 ;j--){
                result.set(j,result.get(j-1));
            }
            result.set(j,tmp);
        }
    }

    public int coparator(ArrayList<Integer> o1,ArrayList<Integer> o2,int index){
        if(o1.size() <= index && o2.size()>index) return -1;
        if(o1.size() > index && o2.size() <= index) return 1;
        int diff = o1.get(index) - o2.get(index);
        if(diff<0) return -1;
        if(diff>0) return 1;
        if(diff == 0)return coparator(o1, o2, index+1);
        return 0;
    }

    public static void main(String [] args){
        Solution71 sol = new Solution71();
        System.out.println(sol.subsets(new int[]{1,2,3}));
    }
}
