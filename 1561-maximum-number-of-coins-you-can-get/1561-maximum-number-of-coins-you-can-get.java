class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);
        int i = 0;
        int j = n - 2;
        int maxCoin = 0;
        while (i < j) {
            maxCoin += piles[j];
            i++;
            j -= 2;
        }
        return maxCoin;
    }
}