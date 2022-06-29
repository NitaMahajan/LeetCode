class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if(n == 1) return 1;
        
        Arrays.sort(pairs, (a,b) -> a[0] - b[0]);
        int dp [] = new int[n];
        Arrays.fill(dp, 1);
        
        int max=-1;
        for(int i = n-2; i >= 0; i--) {
            int value=1;
            for(int j = i+1;j<n;j++) {
                if(pairs[j][0] > pairs[i][1]) {
                    value = Math.max(value, dp[j] + 1);
                }
            }
            dp[i] = value;
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}