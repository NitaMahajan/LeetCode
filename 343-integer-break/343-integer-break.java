class Solution {
    public int integerBreak(int n) {
        int dp[] = new int[n+1];
        dp[2] = 1;
        for(int i = 3; i<=n; i++) {
            int max = -1;
            for(int j = i-1; j>=2;j--) {
                int maxObtainable = Math.max((i-j)*j, dp[j]*(i-j));
                max = Math.max(max, maxObtainable);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}