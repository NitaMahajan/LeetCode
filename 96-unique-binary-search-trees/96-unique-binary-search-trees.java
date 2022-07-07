class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0]=1; 
        dp[1]=1;
        for(int i=2; i<=n;i++) {
            int ways = 0;
            for(int j=1;j<=i;j++){
                ways += dp[j-1]*dp[i-j];
            }
            dp[i] = ways;
        }
        return dp[n];
    }
}