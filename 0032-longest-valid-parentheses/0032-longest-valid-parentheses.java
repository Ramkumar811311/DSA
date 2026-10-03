class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int open = 0;
        int close = 0;

        // left-------->right
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else {
                close++;
            }

            if (close > open) {
                open = 0;
                close = 0;
            }
            if (open == close) {
                int len = open + close;
                maxLen = Math.max(maxLen, len);
            }
        }

        // right-------->left
        open = 0;
        close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else {
                close++;
            }

            if (open > close) {
                open = 0;
                close = 0;
            }
            if (open == close) {
                int len = open + close;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}