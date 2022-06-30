class Solution {
    public int minMoves2(int[] nums) {
        //[1,2,3]
        //[1,2,9,12] //1+8+11=20
        //1+7+10//18
        //8+7+3//18
        //11+10+1=22
        Arrays.sort(nums);
        int mid = nums.length/2;
        int ele = 0, ele2 = -1;
        if(nums.length%2==1) {
            ele = nums[mid];
            int diff=0;
            for(int i=0;i<nums.length;i++) {
                diff+= Math.abs(nums[i]-ele);
            }
            return diff;
        }
        else {
            ele=nums[mid-1]; ele2=nums[mid];
            int diff1=0,diff2=0;
            for(int i=0;i<nums.length;i++) {
                diff1+= Math.abs(nums[i]-ele);
                diff2+=Math.abs(nums[i]-ele2);
            }
            return Math.min(diff1, diff2);
        }
    }
}