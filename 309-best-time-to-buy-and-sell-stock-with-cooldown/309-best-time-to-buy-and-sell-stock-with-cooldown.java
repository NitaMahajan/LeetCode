class Solution {
    public int maxProfit(int[] prices) {
        int s0, s1, s2;
        s0 = 0;
        s1 = -prices[0];
        s2 = Integer.MIN_VALUE;
        for(int i: prices) {
            int olds2 = s2, olds0=s0;
            s2 = s1 + i;
            s0 = Math.max(s0, olds2);
            s1 = Math.max(s1, olds0-i);
        }
        return Math.max(s0, s2);
    }
}