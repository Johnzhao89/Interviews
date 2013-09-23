package Array;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one 
share of the stock), design an algorithm to find the maximum profit.
 * @author heguangliu
 *
 */
public class BestTimetoBuyandSellStock{
	
	// use back to try again
	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices==null || prices.length<=1)
        	return 0;
        int profit =0;
        int min = prices[0];
        for(int i=0; i< prices.length ; i++){
        	min = Math.min(min, prices[i]);// if min, buy when min, if prices[i], buy at i
        	profit = Math.max(profit, prices[i]-min);// if profit, sold at last sold day, if prices[i]-min, sold today
        }
        return profit;
    }
}