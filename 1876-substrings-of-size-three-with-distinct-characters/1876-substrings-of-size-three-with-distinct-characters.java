class Solution {
    public int countGoodSubstrings(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int ans = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            while (set.contains(ch)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            if (r - l + 1 == 3) {
                ans++;
                set.remove(s.charAt(l));
                l++;
            }
            r++;
        }
        return ans;
    }
}