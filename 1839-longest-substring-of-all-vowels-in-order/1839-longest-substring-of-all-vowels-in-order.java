class Solution {
    public int longestBeautifulSubstring(String word) {
        int l = 0;
        int maxLen = 0;
        int unique = 1;
        for (int r = 1; r < word.length(); r++) {
            char curr = word.charAt(r);
            char prev = word.charAt(r - 1);
            if (curr < prev) {
                l = r;
                unique = 1;
            } else if (curr > prev) {
                unique++;
            }

            if (unique == 5) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
        return maxLen;
    }
}