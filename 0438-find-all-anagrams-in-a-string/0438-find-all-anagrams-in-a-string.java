class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         int k = p.length();
        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int r = 0;
        int[] freq = new int[26];
        int[] window = new int[26];

        // Store the frequency of characters in p
        for (int i = 0; i < k; i++) {
            freq[p.charAt(i) - 'a']++;
        }
        while (r < s.length()) {
            char ch = s.charAt(r);
            window[ch - 'a']++;
            if (r - l + 1 > k) {
                char leftChar = s.charAt(l);
                window[leftChar - 'a']--;
                l++;

            }

            if (r - l + 1 == k && Arrays.equals(freq, window)) {
                ans.add(l);
            }
            r++;
        }
        return ans;
    }
}