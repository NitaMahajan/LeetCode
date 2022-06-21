class Solution {
    public int pivotIndex(int[] nums) {
        int prefixSum[] = new int[nums.length];
        int prefixSumBackward = 0;
        prefixSum[0]=nums[0];
        for(int i = 1; i< nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int minAns = nums.length;
        for(int i = nums.length-1;i >= 0;i--) {
            prefixSumBackward += nums[i];
            if(prefixSum[i] == prefixSumBackward) {
                minAns = Math.min(minAns, i);
            }
        }
        if(minAns == nums.length) return -1;
        return minAns;
        
    }
}

// [-1,-1,0,0,-1,-1]
// [-1,-2,-2,-2,-3,-4]
//prefixSumBackward=-2
