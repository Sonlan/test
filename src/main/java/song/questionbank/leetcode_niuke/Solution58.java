package song.questionbank.leetcode_niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Song on 2017/8/9.
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.

 For example,
 If S =[1,2,2], a solution is:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
//不包含重复子集，子集按升序排列
public class Solution58 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        subsetsWithDupCore(num,0,new ArrayList<Integer>(),result);
        sort(result);
        return result;
    }

    public void sort(ArrayList<ArrayList<Integer>> target){
        if(null == target || 1>= target.size()) return;
        ArrayList<Integer> tmp;
        int j;
        for(int i=1;i<target.size();i++){
            tmp = target.get(i);
            for(j=i;j>0 && compare1(tmp,target.get(j-1),0)<0;j--){
                target.set(j,target.get(j-1));
            }
            target.set(j,tmp);
        }
    }
    public int compare1(ArrayList<Integer> o1, ArrayList<Integer> o2,int index){
        if(o1.size() <=index && o2.size()<=index) return 0;
        if(o1.size() >index && o2.size()<=index) return 1;
        if(o1.size() <=index && o2.size() >index) return -1;
        int res = o1.get(index)-o2.get(index);
        if(0 == res) return compare1(o1, o2, index+1);
        return res;
    }

    public void subsetsWithDupCore(int [] num,int start,ArrayList<Integer> curList,ArrayList<ArrayList<Integer>> result){
        if(start>=num.length) {
            result.add(new ArrayList<Integer>(curList));return;
        }
        if(start>=num.length) return;
        int end=start+1;
        for(int i=start+1;i<num.length;i++){
            if(num[i]!=num[start]) {
                end = i;
                break;
            }else if(i == num.length-1){
                end = num.length;
            }
        }
        if(end-start>1) {
            subsetsWithDupCore(num, end, new ArrayList<Integer>(curList), result);
            for (int i = start; i < end; i++) {
                curList.add(num[i]);
                subsetsWithDupCore(num, end, new ArrayList<Integer>(curList), result);
            }
        }else {
            subsetsWithDupCore(num, start+1, new ArrayList<Integer>(curList), result);
            curList.add(num[start]);
            subsetsWithDupCore(num, start+1, new ArrayList<Integer>(curList), result);
        }
    }

    public static void main(String [] args){
        Solution58 sol = new Solution58();
        System.out.println(sol.subsetsWithDup(new int[]{1,1}));
    }
}
