class Solution {
    public boolean checkString(String s) {
        int a = -1;
        int b = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                a = i;
            } else {
                b = i;
            }

            if (a > b) {
                return false;
            }
        }

        return true;
    }
}