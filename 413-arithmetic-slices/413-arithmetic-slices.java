class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int slices = 0, previous = 0;
        for(int i = 2; i < nums.length; i++) {
            previous = ((nums[i] - nums[i-1]) == (nums[i-1] - nums[i-2])) ? previous + 1 : 0;
            slices = slices + previous;
        }
        return slices;
    }
    
}