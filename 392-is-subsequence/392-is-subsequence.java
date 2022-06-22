class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        if(t.length() == 0 && s.length() == 0) return true;
        if(t.length() == 0) return false;
        if(s.length() == 0) return true;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++; j++;
            } else {
                j++;
            }
        }
        if(i < s.length()) return false;
        return true;
    }
}