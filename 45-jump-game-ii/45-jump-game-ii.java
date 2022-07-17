class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int dp[]= new int[n];
        dp[n-1]=0;
        for(int i = n-2;i>=0;i--) {
            int minDis = 100001;
            if(nums[i] == 0) {
                dp[i] = minDis;
                continue;
            }
            for(int j=i+1; j <= Math.min(i + nums[i], n-1); j++) {
                minDis = Math.min(minDis, 1 + dp[j]);
            }
            dp[i] = minDis;
        }
        return dp[0];
    }
}