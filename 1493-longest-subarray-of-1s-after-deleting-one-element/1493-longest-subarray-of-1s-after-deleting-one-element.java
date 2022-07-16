class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j,k=1,len=0;
        for(j=0;j<nums.length;j++) {
            if(nums[j] == 0){
                k--;
            }
            while(k < 0) {
                if(nums[i] == 0) {
                    k++;
                }
                i++;
            }
            len = Math.max(len, j-i);
        }
        return len;
        
    }
}