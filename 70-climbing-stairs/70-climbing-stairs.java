class Solution {
    public int climbStairs(int n) {
        int fibNMinusTwo = 1;
        int fibNMinusOne = 2;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int fibN = 0;
        for(int i=3;i<=n;i++) {
            fibN = fibNMinusTwo + fibNMinusOne;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }
}