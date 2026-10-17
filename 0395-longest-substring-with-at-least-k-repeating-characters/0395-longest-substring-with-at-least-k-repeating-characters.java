class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;

        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (freq.get(ch) < k) {
                    break;
                }
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                boolean possible = true;

                for (int val : map.values()) {
                    if (val < k) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}