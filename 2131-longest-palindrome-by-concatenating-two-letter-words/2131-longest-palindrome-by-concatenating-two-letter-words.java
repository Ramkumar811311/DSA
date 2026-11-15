class Solution {
    public int longestPalindrome(String[] words) {
        boolean isCentredUsed = false;
        int len = 0;
        int freq[][] = new int[26][26];
        for (int i = 0; i < words.length; i++) {
            int ind1 = words[i].charAt(0) - 'a';
            int ind2 = words[i].charAt(1) - 'a';
            freq[ind1][ind2] += 1;
        }
        for (String word : words) {
            int ind1 = word.charAt(0) - 'a';
            int ind2 = word.charAt(1) - 'a';

            int r_ind1 = ind2;
            int r_ind2 = ind1;
            if (ind1 != ind2) {
                if (freq[ind1][ind2] > 0 && freq[r_ind1][r_ind2] > 0) {
                    freq[ind1][ind2]--;
                    freq[r_ind1][r_ind2]--;
                    len += 4;
                }
            } else {
                if (freq[ind1][ind2] > 1) {
                    len += 4;
                    freq[ind1][ind2] -= 2;
                } else if (freq[ind1][ind2] == 1 && !isCentredUsed) {
                    len += 2;
                    isCentredUsed = true;
                }
            }

        }
        return len;
    }
}