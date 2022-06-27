class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        dp[n] = 1; // Base case;
        for(int i = n-1; i>=0;i--) {
            int curr = Character.getNumericValue(s.charAt(i));
            if(i == n-1 && curr != 0) { // last element
                dp[i] = 1;
            } else if(curr == 0){ // if curr element is 0
                dp[i] = 0;
            } else {
                int next = Character.getNumericValue(s.charAt(i+1));
                if((curr*10 + next) <= 26) {
                    dp[i] = dp[i+1] + dp[i+2];
                } else {
                    dp[i] = dp[i+1];
                }
            }
        }
        return dp[0];
        
    }
}