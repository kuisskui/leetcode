package bestTimeToBuyAndSellStockII;

public class Solution {

    final private static String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/";

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    public int bestRuntimeSolution(int[] prices) {
        int n = prices.length;
        boolean bought = false;
        int boughtprice = 0;
        int total = 0;
        for( int i = 0 ; i < n ; i++ ) {
            if( bought) {
                if( i == n - 1) {
                    total += prices[i] - boughtprice;
                    bought = false;
                } else {
                    if( prices[i+1] < prices[i]) {
                        total += prices[i] - boughtprice;
                        bought = false;
                    }
                }
            } else {
                if( i < n-1 ) {
                    if( prices[i+1] > prices[i]) {
                        bought = true;
                        boughtprice = prices[i];
                    }
                }
            }
        }
        return total;
    }
}
