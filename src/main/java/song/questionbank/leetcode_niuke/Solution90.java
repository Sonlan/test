package song.questionbank.leetcode_niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Song on 2017/8/23.
 * The set[1,2,3,…,n]contains a total of n! unique permutations.
 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):
 "123"
 "132"
 "213"
 "231"
 "312"
 "321"

 Given n and k, return the k th permutation sequence.
 Note: Given n will be between 1 and 9 inclusive.
 */
//值得学习，通过计算阶乘（排列数）,计算出每一位上的数字,见getPermutation1
public class Solution90 {
    private boolean flag = false;
    public String getPermutation(int n, int k) {
        int [] data = new int[n];
        for(int i=0;i<n;i++){
            data[i] = i+1;
        }
        ArrayList<String> result = new ArrayList<>();
        getPermutationCore(data,n,k,0,new StringBuilder(),result);
        if(result.size()>=k)
            return result.get(k-1);
        else return null;
    }

    public void getPermutationCore(int [] data,int n, int k, int index, StringBuilder sb, ArrayList<String> result){
       if(index >= n){
           result.add(sb.toString());
           if(result.size() == k){
               flag = true;
           }
       }
       for(int i = index;i<n;i++){
           swap(index,i,data);
           sb.append(data[index]);
           getPermutationCore(data, n, k, index + 1, sb, result);
           sb.deleteCharAt(sb.length()-1);
           swap(index,i,data);
       }
    }

    public void swap(int i,int j,int [] data){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String [] args){
        Solution90 sol = new Solution90();
        System.out.println(sol.getPermutation1(3,1));
    }


    public String getPermutation1(int n, int k) {
        int [] jc = new int[n]; //阶乘
        List<Integer> list = new ArrayList<>();
        jc[0] = 1;
        for(int i=1;i<n;i++){
            list.add(i);
            jc[i] = jc[i-1]*i;
        }
        list.add(n);
        StringBuilder sb = new StringBuilder();
        int arg1;
        k = k-1;
        for(int i=0;i<n;i++){
            arg1 = k/jc[n-1-i];
            k = k- arg1*jc[n-1-i];
            sb.append(list.get(arg1));
            list.remove(arg1);
        }
        return sb.toString();
    }

}
