class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int fMinusTwo = 0;
        int fMinusOne = 1;
        for(int i=2; i<=n;i++) {
            int fn = fMinusTwo + fMinusOne;
            fMinusTwo = fMinusOne;
            fMinusOne = fn;
        }
        return fMinusOne;
    }
}