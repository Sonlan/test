package song.questionbank.leetcode_niuke;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Song on 2017/7/6.
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 For example,
 Given[100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 Your algorithm should run in O(n) complexity.
 */
public class Solution23 {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>(num.length);
        for(int val:num){
            set.add(val);
        }
        Iterator<Integer> iterator = set.iterator();
        int max = 1;
        int val = 0,temp = 0,count =1;
        while (iterator.hasNext()){
            val = iterator.next();
            temp = val;
            count = 1;
            if(set.remove(temp)){
                while (set.remove(--temp)) count++;
                temp = val;
                while (set.remove(++temp)) count++;
                max = max>count?max:count;
                iterator = set.iterator();
            }
        }
        return max;
    }

    public static void main(String [] args){
        Solution23 sol = new Solution23();
        System.out.println(sol.longestConsecutive(new int[]{5,4,1,2,6,10}));
    }
}
