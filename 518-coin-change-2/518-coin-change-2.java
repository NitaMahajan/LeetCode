class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        for(int i = 0; i <= coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                if(j == 0) dp[i][j] = 1;
                else if(i == 0) dp[i][j] = 0;
                else if(coins[i-1] <= j) {
                    // Number of ways when we dont consider ith coin: dp[i-1][j]
                    // Number of ways when we consider ith coin: dp[i][j - coins[i-1]]
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
                else{
                    // If coin is greater than sum required, we only have one choice
                    // i.e to not consider the coin
                    dp[i][j] = dp[i-1][j];
                }
                    
                
            }
        }
        return dp[coins.length][amount];
    }
}