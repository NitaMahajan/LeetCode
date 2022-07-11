class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int W = getSum(nums);
        if(W % 2 != 0) return false;
        W = W/2;
        boolean dp[][]=new boolean[n+1][W+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = true;
        }
        for(int i=n-1;i>=0;i--) {
            for(int w=1;w<=W;w++) {
                if(nums[i] <= w) { // We can take this number
                    dp[i][w] = dp[i+1][w-nums[i]] || dp[i+1][w];
                } else {
                    dp[i][w] = dp[i+1][w];
                }
            }
        }
        return dp[0][W];
    }
    
    public int getSum(int arr[]) {
        int sum = 0;
        for(int num: arr) sum+=num;
        return sum;
    }
}