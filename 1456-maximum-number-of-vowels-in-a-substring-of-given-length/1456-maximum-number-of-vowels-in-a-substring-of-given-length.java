class Solution {
    public int maxVowels(String s, int k) {
        int maxVowel = 0;
        int countVowel = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                countVowel++;
            }
            if (r - l + 1 > k) {
                char leftCh = s.charAt(l);
                if (leftCh == 'a' || leftCh == 'e' || leftCh == 'i' || leftCh == 'o' || leftCh == 'u') {
                    countVowel--;
                }
                l++;
            }

            if (r - l + 1 == k) {
                maxVowel = Math.max(maxVowel, countVowel);
            }
            r++;
        }
        return maxVowel;
    }
}