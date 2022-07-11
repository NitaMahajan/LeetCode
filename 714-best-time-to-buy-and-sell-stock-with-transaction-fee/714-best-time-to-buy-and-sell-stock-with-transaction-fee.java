class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = -prices[0];
        int sell = 0;
        for(int i=1;i<n;i++) {
            int copyBuy = buy, copySell = sell;
            buy = Math.max(copySell - prices[i], copyBuy);
            sell = Math.max(copyBuy + prices[i] - fee, copySell);
        }
        return sell > 0 ? sell: 0;
    }
}