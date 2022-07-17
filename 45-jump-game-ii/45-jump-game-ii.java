class Solution {
    public int jump(int[] nums) {
        int jumps = 0, currEnd = 0, currFarthest = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, nums[i] + i);
            if(i == currEnd) {
                jumps++;
                currEnd = currFarthest;
            }
        }
        return jumps;
    }
}

//[2,3,1,1,4]
//curEnd = 4, currFarthest=4, jumps=2
