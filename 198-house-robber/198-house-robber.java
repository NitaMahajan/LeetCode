class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int max = -1;
        int dp[] = new int[n];
        dp[n-1] = nums[n-1];
        dp[n-2] = nums[n-2];
        max = Math.max(dp[n-1], dp[n-2]);
        for(int i = n-3; i>=0;i--) {
            for(int j = i+2;j<n;j++) {
                dp[i] = Math.max(dp[i], nums[i] + dp[j]);
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}