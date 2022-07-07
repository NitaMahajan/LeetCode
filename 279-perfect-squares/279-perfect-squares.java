class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[1] = 1;
        for(int j=2; j <= n;j++) {
            dp[j] = j;
            for(int i=1; i*i <= j; i++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - i*i]);
            }
        }
        return dp[n];
    }
}