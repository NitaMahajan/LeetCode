class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0, imax = 0;
        for(int i = 0; i < values.length; ++i) {
            res = Math.max(res, imax + values[i] - i);
            imax = Math.max(imax, values[i] + i);
        }
        return res;
    }
}