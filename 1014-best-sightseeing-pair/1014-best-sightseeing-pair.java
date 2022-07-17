class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxFirst = 0, maxProfit = 0;
        for(int i=1; i < values.length; i++) {
            int value_1 = values[maxFirst] + maxFirst + values[i] - i;
            int value_2 = values[i-1] + (i-1) + values[i] - i;
            maxProfit = Math.max(maxProfit, Math.max(value_1, value_2));
            if(value_2 >= value_1) {
                maxFirst = i-1;
            }
        }
        return maxProfit;
    }
}