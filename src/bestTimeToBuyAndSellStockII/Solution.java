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
}
