class Solution {
    public int maximumLengthSubstring(String s) {
        
        int maxlen = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while (r<s.length()) {
            char ch = s.charAt(r);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
            while (l < s.length() && map.get(ch)>2) {
               
               map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;

        }
        return maxlen;
    }
}