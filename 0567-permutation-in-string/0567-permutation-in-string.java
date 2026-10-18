class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int freq[] = new int[26];
        int window[] = new int[26];
        int k = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            freq[ch - 'a']++;
        }
        int l = 0;
        int r = 0;
        while (r < s2.length()) {
            char ch = s2.charAt(r);
            window[ch - 'a']++;
            if (r - l + 1 > k) {
                char leftChar = s2.charAt(l);
                window[leftChar - 'a']--;
                l++;
            }
            if (r - l + 1 == k && Arrays.equals(freq, window)) {
                return true;
            }
            r++;
        }
        return false;
    }
}