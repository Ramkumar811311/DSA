class Solution {
    public int minimumDeletions(String word, int k) {
        int minDeletion = Integer.MAX_VALUE;
        int freq[] = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            int noOfDeletion = 0;
            for (int j = 0; j < 26; j++) {
                if (i == j || freq[j] == 0)
                    continue;

                if (freq[j] < freq[i]) {
                    noOfDeletion += freq[j];
                } else if (Math.abs(freq[i] - freq[j]) > k) {
                    noOfDeletion += Math.abs(freq[i] - freq[j]) - k;
                }
            }
            minDeletion = Math.min(minDeletion, noOfDeletion);
        }
        return minDeletion;
    }
}