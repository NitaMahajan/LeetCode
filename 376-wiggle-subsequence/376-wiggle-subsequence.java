class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        if(n==2 && (nums[0] != nums[1])) return 2;
        if(n==2 && (nums[0] == nums[1])) return 1;
        int diff[] = new int[n-1];
        boolean isZero = true;
        for(int i=0;i < n-1;i++) {
            diff[i] = nums[i+1]-nums[i];
            if(diff[i] != 0) isZero=false;
        }
        if(isZero) return 1;
        int len = 1; 
        int lastDiff=diff[0];
        for(int i=1;i<n-1;i++) {
            if(lastDiff == 0) {
                lastDiff = diff[i];
            }
            else if((lastDiff>0 && diff[i] < 0) || (lastDiff<0 && diff[i] > 0)) {
                len++;
                lastDiff = diff[i];
            }
        }
        return len+1;
    }
}