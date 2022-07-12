class Solution {
    public int knightDialer(int n) {
        if(n==1) return 10;
        final long M = 1_000_000_007;
        long dp[][] = new long[n+1][10];
        initialize(dp);
        for(int i=3;i<=n;i++) {
            for(int j=0;j<10;j++) {
                if(j == 0) dp[i][j] = (dp[i-1][4]%M +  dp[i-1][6]%M)%M;
                else if(j == 1) dp[i][j] = (dp[i-1][6]%M +  dp[i-1][8]%M)%M;
                else if(j == 2) dp[i][j] = (dp[i-1][7]%M +  dp[i-1][9]%M)%M;
                else if(j == 3) dp[i][j] = (dp[i-1][4]%M +  dp[i-1][8]%M)%M;
                else if(j == 4) dp[i][j] = (dp[i-1][0]%M +  dp[i-1][3]%M+dp[i-1][9]%M)%M;
                else if(j == 5) dp[i][j] = 0;
                else if(j == 6) dp[i][j] = (dp[i-1][0]%M +  dp[i-1][1]%M + dp[i-1][7]%M)%M;
                else if(j == 7) dp[i][j] = (dp[i-1][2]%M +  dp[i-1][6]%M)%M;
                else if(j == 8) dp[i][j] = (dp[i-1][1]%M +  dp[i-1][3]%M)%M;
                else if(j == 9) dp[i][j] = (dp[i-1][2]%M +  dp[i-1][4]%M)%M;
            }
        }
        long sum = 0;
        for(int i=0;i<10;i++) {
            sum = (sum + (dp[n][i]%M))%M;
        }
        return (int)sum;
    }
    public void initialize(long dp[][]) {
        for(int i=0;i<10;i++) {
            if(i==4 || i==6) dp[2][i] = 3;
            else if(i == 5) dp[2][i] = 0;
            else dp[2][i] = 2;
        }
    }
}