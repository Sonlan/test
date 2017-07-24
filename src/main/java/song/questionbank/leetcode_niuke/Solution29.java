package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/23.
 * Say you have an array for which the i th element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 (ie, buy one and sell one share of the stock multiple times). However,
 you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Solution29 {
    public int maxProfit(int[] prices) {
        int diff = 0,max=0;
        for(int i=1;i<prices.length;i++){
            if((diff = prices[i]-prices[i-1])>0){
                max+=diff;
            }
        }
        return max;
    }
}
