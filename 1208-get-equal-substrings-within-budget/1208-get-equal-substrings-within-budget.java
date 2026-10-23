class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int cost = 0;
        int maxlen = 0;
        int l = 0;
        int r = 0;
        while (r < n) {
            char ch1 = s.charAt(r);
            char ch2 = t.charAt(r);
            cost += Math.abs(ch1 - ch2);
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }
}