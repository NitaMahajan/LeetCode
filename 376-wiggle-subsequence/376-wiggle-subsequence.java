class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;
        int previous = nums[1] - nums[0]; 
        int length = previous == 0 ? 1: 2;
        for(int i=2;i<n;i++) {
            int current = nums[i] - nums[i-1];
            if((current < 0 && previous >= 0) || (current > 0 && previous <= 0)) {
                length++;
                previous = current;
            }
        }
        return length;
    }
}