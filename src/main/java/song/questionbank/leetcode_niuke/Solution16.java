package song.questionbank.leetcode_niuke;

import java.util.Arrays;

/**
 * Created by Song on 2017/6/27.
 * There are N children standing in a line. Each child is assigned a rating value.
 You are giving candies to these children subjected to the following requirements:
 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */
public class Solution16 {
    public int candy(int[] ratings) {
        int [] count = new int[ratings.length];
        Arrays.fill(count,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1])
                count[i] = count[i-1]+1;
        }
        int sum = count[ratings.length-1];
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && count[i]<=count[i+1])
                count[i] = count[i+1]+1;
            sum+=count[i];
        }
        System.out.println(count);
        return sum;
    }

    public static void main(String [] args){
        Solution16 sol = new Solution16();
        System.out.println(sol.candy(new int[]{2,1}));
    }

}
