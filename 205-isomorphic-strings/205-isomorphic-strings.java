class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        Map<Character,Character> reverseMap = new HashMap<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length(); i++) {
            if(!map.containsKey(sb.charAt(i))) {
                map.put(sb.charAt(i), t.charAt(i));
                if(reverseMap.containsKey(t.charAt(i)) && (reverseMap.get(t.charAt(i)) != sb.charAt(i))) 
                    return false;
                reverseMap.put(t.charAt(i), sb.charAt(i));
                sb.setCharAt(i, t.charAt(i));
            } else {
                sb.setCharAt(i, map.get(sb.charAt(i)));
            }
        }
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) != t.charAt(i)) return false;
        }
        return true;
    }
}