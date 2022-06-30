class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long sumEven = 0, sumOdd = 0;
        for(int i = n-1; i>=0; i--) {
            long tmpEven = Math.max(sumOdd + nums[i], sumEven);
            long tmpOdd = Math.max(sumEven - nums[i], sumOdd);
            sumEven = tmpEven; sumOdd = tmpOdd;
        }
        return sumEven;
        
    }
}