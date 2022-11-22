class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) sum=0;
        }
        return maxSum;
    }
}

// [-2,1,-3,4,-1,2,1,-5,4]
// maxSumSoFar=-Inf
// sum=0+-2 = -2;
// maxSumSoFar=-2
// sum=0+1=1
// maxSumSoFar=1
// sum=1+-3=-2=0
// sum=0+4=4;
// maxSumSoFar=4=5=6
// sum=3+2=5+1=6+-5=1+4=5