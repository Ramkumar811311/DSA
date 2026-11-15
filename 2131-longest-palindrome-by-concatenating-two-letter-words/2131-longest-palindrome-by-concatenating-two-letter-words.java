class Solution {
    public int longestPalindrome(String[] words) {
        boolean isCentredUsed = false;
        int len = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (!map.containsKey(word) || !map.containsKey(reverse)) {
                continue;
            }
            if (!reverse.equals(word)) {
                if (map.get(word) > 0 && map.get(reverse) > 0) {
                    map.put(word, map.get(word) - 1);
                    map.put(reverse, map.get(reverse) - 1);
                    len += 4;
                }
            } else {
                if (map.get(word) > 1) {
                    len += 4;
                    map.put(word, map.get(word) - 2);
                } else if (map.get(word) == 1 && !isCentredUsed) {
                    len += 2;
                    isCentredUsed = true;
                }
            }

        }
        return len;
    }
}