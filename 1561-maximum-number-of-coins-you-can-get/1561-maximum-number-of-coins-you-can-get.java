class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);
        int bob = 0;
        int me = n - 2;
        int maxCoin = 0;
        while (bob < me) {
            maxCoin += piles[me];
            bob++;
            me -= 2;
        }
        return maxCoin;
    }
}