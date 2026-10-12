class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int ans = 0;
        int count0 = 0;
        int count1 = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (ch == '1') {
                count1++;
            } else {
                count0++;
            }
            while (count0 > k && count1 > k) {
                if (s.charAt(l) == '1') {
                    count1--;
                } else {
                    count0--;
                }
                l++;
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}