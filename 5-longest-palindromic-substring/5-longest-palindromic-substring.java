class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int leftIndex = n, rightIndex = 0;
        int resLen = 0;
        for(int i = 0; i < n; i++) {
            // Odd palindrome
            int left = i, right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if((right - left + 1) > resLen) {
                    resLen = (right - left + 1);
                    leftIndex = left;
                    rightIndex = right;
                }
                left--; right++;
            }
            // Even palindrome
            left = i; right = i+1;
             while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                 if((right - left + 1) > resLen) {
                    resLen = (right - left + 1);
                    leftIndex = left;
                    rightIndex = right;
                 }
                 left--; right++;
             }
        }
        return s.substring(leftIndex, rightIndex + 1);
    }
}