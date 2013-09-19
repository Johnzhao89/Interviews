package Array;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author heguangliu
 *
 */
public class BestTimetoBuyandSellStockIII{
	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices == null || prices.length <=1)
        	return 0;
        int maxProfit =0;
        int start =1;
        while(prices[start-1]>=prices[start]){
        	if(start == prices.length -1)
        		return 0;
        	start++;
        }
        for(int i=start ;i< prices.length-1; i++){
        	maxProfit = Math.max(maxProfit,maxProfitHelper(prices, start, start-1)+maxProfitHelper(prices, i+1, prices.length-1));
        }
        return maxProfit;
    }
	
	public int maxProfitHelper(int[] prices, int start, int end) {
        if(prices==null || prices.length<=1)
        	return 0;
        int profit =0;
        int min = prices[start];
        for(int i=start; i<= end ; i++){
        	min = Math.min(min, prices[i]);// if min, buy when min, if prices[i], buy at i
        	profit = Math.max(profit, prices[i]-min);// if profit, sold at last sold day, if prices[i]-min, sold today
        }
        return profit;
    }
}