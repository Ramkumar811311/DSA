class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0;
        int bob = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            char curr = colors.charAt(i);
            char prev = colors.charAt(i - 1);
            char next = colors.charAt(i + 1);
            if (curr == prev && curr == next) {
                if (curr == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }
        }
        return alice>bob;
    }
}