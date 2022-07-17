class Solution {
    public boolean canJump(int[] nums) {
        int iReachable = 0;
        for(int i = 0; i <= iReachable; i++) {
            iReachable = Math.max(iReachable, nums[i] + i);
            if(iReachable >= nums.length-1) return true;
        }
        return false;
    }
}