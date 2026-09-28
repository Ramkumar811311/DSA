class Solution {
    public int maxDepth(String s) {
        int counter = 0;
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                counter++;
            } else if (ch == ')') {
                counter--;
            }
            maxCount = Math.max(counter, maxCount);
        }
        return maxCount;
    }
}