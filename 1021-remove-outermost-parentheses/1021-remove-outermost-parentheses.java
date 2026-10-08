class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (count == 0) {
                    count++;
                    continue;
                }
                count++;
            }
            if (ch == ')') {
                count--;
                if (count == 0) {
                    continue;
                }
            }
            ans += ch;
        }
        return ans;
    }
}