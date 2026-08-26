class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int l = 0;
        int r = 0;
        int count = 0;
        int minlen = Integer.MAX_VALUE;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (ch == '1') {
                count++;
            }
             while (l <= r && count == k) {
                int len = r - l + 1;
                String curr = s.substring(l, r + 1);

                if (len < minlen) {
                    minlen = len;
                    ans = s.substring(l, r + 1);
                } else if (len == minlen && curr.compareTo(ans) < 0) {
                    ans = curr;
                }

                if (s.charAt(l) == '1') {
                    count--;
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}