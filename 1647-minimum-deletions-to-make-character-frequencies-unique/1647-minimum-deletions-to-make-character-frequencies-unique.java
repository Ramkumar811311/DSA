class Solution {
    public int minDeletions(String s) {
        int deletion = 0;
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while(freq[i]>0 && set.contains(freq[i])){
                deletion++;
                freq[i]--;
            }
            if (freq[i]>0) {
                set.add(freq[i]);
            }
        }
        return deletion;
    }
}