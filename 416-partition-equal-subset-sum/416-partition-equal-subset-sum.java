class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int W = getSum(nums);
        if(W % 2 != 0) return false;
        W = W/2;
        boolean dpRow[]=new boolean[W+1];
        dpRow[0] = true;
        for(int i=n-1;i>=0;i--) {
            for(int w=W; w>=0; w--) {
                if(nums[i] <= w) { // We can take this number
                    dpRow[w] = dpRow[w-nums[i]] || dpRow[w];
                } else {
                    dpRow[w] = dpRow[w];
                }
            }
        }
        return dpRow[W];
    }
    
    public int getSum(int arr[]) {
        int sum = 0;
        for(int num: arr) sum+=num;
        return sum;
    }
}