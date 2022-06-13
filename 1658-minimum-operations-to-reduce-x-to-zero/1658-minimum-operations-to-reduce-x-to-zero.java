class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0, right = 0, sum = 0, res = Integer.MAX_VALUE, n = nums.length;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        while(left <= right) {
            if(sum >= x) {
                if(sum == x)
                    res = Math.min(res, left + n - right);
                if(right < n) 
                    sum -= nums[right++];
                else 
                    break;
            }else{
                sum += nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}