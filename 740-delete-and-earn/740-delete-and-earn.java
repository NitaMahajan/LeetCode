class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        Arrays.sort(nums);
        for(int i: nums) {
            if(!count.containsKey(i)) {
                count.put(i, 1);
            }
            else {
                count.put(i, count.get(i) + 1);
            }
        }
        int n = nums.length;   
        int dp[]=new int[n+1];
        dp[n] = 0;
        
        int i=n-1;
        while(i >= 0) {
            if((i < n-1) && nums[i] == nums[i + 1]) {
                dp[i] = dp[i + 1];
                i--; continue;
            }
            int profit = 0;
            if((i == nums.length-1) || (nums[i] + 1 != nums[i+1])) {
                profit = (count.get(nums[i]) * nums[i]) + dp[i+1];
            } else {
                profit = Math.max((count.get(nums[i]) * nums[i]) + dp[i+count.get(nums[i+1])+1],dp[i+1]);
            }
            dp[i] = profit;
            i--;
        }
        return dp[0];
        
    }
}