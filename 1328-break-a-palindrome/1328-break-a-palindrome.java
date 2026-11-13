class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder(palindrome);
        boolean isChanged = false;
        for (int i = 0; i < n / 2; i++) {
            char ch = palindrome.charAt(i);
            if (ch != 'a') {
                sb.setCharAt(i, 'a');
                isChanged = true;
                return sb.toString();
            }
        }
        if (isChanged == false) {
            sb.setCharAt(n - 1, 'b');
        }
        return sb.toString();
    }
}