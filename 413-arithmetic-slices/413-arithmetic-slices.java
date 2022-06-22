class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int start = 0, next = start + 1, diff = 0;
        int count = 0;
        
        while(start < n - 2) {
            if(next == (start + 1)) {
                diff = nums[next] - nums[start];
                next++;
            } else {
                if((nums[next] - nums[next - 1]) == diff) {
                    count++;
                    next++;
                } else {
                    start++;
                    next = start+1;
                }
            }
            if(next >= n) {
                start++;
                next = start+1;
            }
        }
        return count;
    }
    
}