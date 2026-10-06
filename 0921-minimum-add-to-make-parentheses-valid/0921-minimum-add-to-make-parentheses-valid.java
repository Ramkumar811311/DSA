class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                count = 0;
                ans++;
            }
        }
        return Math.abs(count + ans);
    }
}