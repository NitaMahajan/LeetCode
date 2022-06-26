class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = getSum(nums);
        int memoize[][] = new int[nums.length + 1][2*sum + 1];
        initialize(memoize);
        int ans = calculate(nums, memoize, sum, 0, 0, target);
        return ans;
    }
    
    public int calculate(int nums[], int[][] memoize, int len, int index, int sum, int target) {
        
        if(index == nums.length){
            if(sum == target) {
                memoize[index][normalize(sum, len)] = 1;
                return 1;
            } else {
                memoize[index][normalize(sum, len)] = 0;
                return 0;
            }
        }
        int left = memoize[index + 1][normalize(sum+nums[index], len)];
        int right = memoize[index + 1][normalize(sum-nums[index], len)];
        if(left == -1) left = calculate(nums,memoize,len,index+1,sum+nums[index],target);
        if(right == -1) right = calculate(nums,memoize,len,index+1,sum-nums[index],target);
        return left + right;
    }
    
    public int getSum(int nums[]) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
    public int normalize(int sum, int size) {
        return sum + size;
    }
    
    public void initialize(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                arr[i][j] = -1;
            }
        }
    }
}