class Solution {
    int count = 0;
    public int countArrangement(int n) {
        int nums [] = new int[n];
        for(int i = 0; i < n;i++) {
            nums[i] = (i + 1);
        }
        permute(nums, 0);
        return count;
    }
    public void permute(int nums[], int curr) {
        if(curr == nums.length) {
            count++;
        }
        for(int i = curr; i < nums.length; i++) {
            swap(nums, i, curr);
            if(( (nums[curr]%(curr+1)) == 0) || ( ((curr+1)%nums[curr]) == 0)) 
                permute(nums, curr + 1);
            swap(nums, i, curr);
        }
    }
    public void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}