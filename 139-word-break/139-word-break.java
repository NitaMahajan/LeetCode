class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean memoize[] = new boolean[n + 1];
        memoize[n] = true;
        for(int i = n-1; i >= 0; i--) {
            for(String word: wordDict) {
                if(word.length() > (n-i)) continue;
                int itr = i, j = 0;
                while((itr < n && j < word.length()) && (s.charAt(itr) == word.charAt(j))) {
                    itr++; j++;
                }
                if(j == word.length()) {
                    memoize[i] = memoize[i + word.length()];
                    if(memoize[i]) break;
                }
            }
        }
        return memoize[0];
    }
}