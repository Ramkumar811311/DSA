class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int maxScore = 0;
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score++;
                i++;
            } else if (score >= 1) {
                score--;
                power += tokens[j];
                j--;
            } else {
                break;
            }
            maxScore = Math.max(score, maxScore);
        }
        return maxScore;
    }
}