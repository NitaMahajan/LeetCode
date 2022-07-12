class Solution {
    public int knightDialer(int n) {
        if(n==1) return 10;
        final long M = 1_000_000_007;
        long dp[] = new long[10];
        // long dp[][] = new long[n+1][10];
        initialize(dp);
        for(int i=3;i<=n;i++) {
            long _dp[] = new long[10];
            for(int j=0;j<10;j++) {
                if(j == 0) _dp[j] = (dp[4]%M +  dp[6]%M)%M;
                else if(j == 1) _dp[j] = (dp[6]%M +  dp[8]%M)%M;
                else if(j == 2) _dp[j] = (dp[7]%M +  dp[9]%M)%M;
                else if(j == 3) _dp[j] = (dp[4]%M +  dp[8]%M)%M;
                else if(j == 4) _dp[j] = (dp[0]%M +  dp[3]%M+dp[9]%M)%M;
                else if(j == 5) _dp[j] = 0;
                else if(j == 6) _dp[j] = (dp[0]%M +  dp[1]%M + dp[7]%M)%M;
                else if(j == 7) _dp[j] = (dp[2]%M +  dp[6]%M)%M;
                else if(j == 8) _dp[j] = (dp[1]%M +  dp[3]%M)%M;
                else if(j == 9) _dp[j] = (dp[2]%M +  dp[4]%M)%M;
            }
            dp = _dp;
        }
        long sum = 0;
        for(int i=0;i<10;i++) {
            sum = (sum + (dp[i]%M))%M;
        }
        return (int)sum;
    }
    public void initialize(long dp[]) {
        for(int i=0;i<10;i++) {
            if(i==4 || i==6) dp[i] = 3;
            else if(i == 5) dp[i] = 0;
            else dp[i] = 2;
        }
    }
}