class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int minTime = 0, prev = 0, i = 1;
        while(i < n) {
            if(colors.charAt(i) == colors.charAt(prev)) {
                if(neededTime[i] > neededTime[prev]) {
                    minTime += neededTime[prev];
                    prev = i;
                } else {
                    minTime += neededTime[i];
                }
                i += 1;
            } 
            else {
                prev = i; 
                i += 1;
            }
        }
        return minTime;
    }
}