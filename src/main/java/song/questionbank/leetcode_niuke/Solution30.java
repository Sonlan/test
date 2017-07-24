package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/23.
 * Say you have an array for which the i th element is the price of a given stock on day i.
 If you were only permitted to complete at most one transaction
 (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class Solution30 {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        if(prices.length<=1) return maxProfit;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            maxProfit = prices[i]-min>maxProfit?prices[i]-min:maxProfit;
        }
        return maxProfit;
    }
}
