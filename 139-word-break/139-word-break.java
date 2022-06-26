class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int memoize[] = new int[s.length()+1];
        return wordBreak(s, wordDict,memoize, 0);
    }
    public boolean wordBreak(String s, List<String> wordDict, int[] memoize,int index) {
        if(index == s.length()) {
            return true;
        }
        for(String word: wordDict) {
            int i = index, j = 0;
            while((i < s.length() && j < word.length()) && (s.charAt(i) == word.charAt(j))) {
                i++; j++;
            }
            if(j == word.length()) {// we can use the word
                int res = memoize[i];
                if(res == 0) {
                    memoize[i] = wordBreak(s, wordDict, memoize,i) ? 1 : -1;
                }
                if(memoize[i] == 1) {
                    return true;
                }
            }
        }
        memoize[index] = -1;
        return false;
    }
}