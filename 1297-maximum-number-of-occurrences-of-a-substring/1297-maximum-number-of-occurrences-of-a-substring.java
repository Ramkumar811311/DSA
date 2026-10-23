class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        int freq[] = new int[26];
        int distinct = 0;
        int maxFreq = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            int index = s.charAt(r) - 'a';
            if (freq[index] == 0) {
                distinct++;
            }
            freq[index]++;

            if (r - l + 1 > minSize) {
                int leftIndex = s.charAt(l) - 'a';

                freq[leftIndex]--;

                if (freq[leftIndex] == 0) {
                    distinct--;
                }

                l++;
            }
            if (r - l + 1 == minSize && distinct <= maxLetters) {
                String sub = s.substring(l, r + 1);

                map.put(sub, map.getOrDefault(sub, 0) + 1);

                maxFreq = Math.max(maxFreq, map.get(sub));
            }

            r++;
        }
        return maxFreq;
    }
}