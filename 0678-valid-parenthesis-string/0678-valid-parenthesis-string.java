class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> asterisk = new Stack<>();
        Stack<Integer> openBracet = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openBracet.push(i);
            } else if (ch == '*') {
                asterisk.push(i);
            } else {
                if (!openBracet.isEmpty()) {
                    openBracet.pop();
                } else if (!asterisk.isEmpty()) {
                    asterisk.pop();
                } else {
                    return false;
                }
            }
        }
        while (!openBracet.isEmpty() && !asterisk.isEmpty()) {
            if (openBracet.peek() > asterisk.peek()) {
                return false;
            }
            openBracet.pop();
            asterisk.pop();
        }
        return openBracet.isEmpty();
    }
}