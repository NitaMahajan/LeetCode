class Solution {
    public boolean halvesAreAlike(String s) {
        int a=0,b=0;
        for(int i = 0, j = s.length() - 1 ; i < (s.length()/2); i++, j--) {
            if(isVowel(s.charAt(i))) a++;
            if(isVowel(s.charAt(j))) b++;
        }
        return (a==b);
    }
    boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        return (vowels.indexOf(c) != -1);
    }
}