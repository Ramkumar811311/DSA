class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long maxHappiness = 0;
        int n = happiness.length;
        Arrays.sort(happiness);
        for (int i = 0; i < k; i++) {
            maxHappiness += Math.max(0, happiness[n - 1 - i] - i);
        }
        return maxHappiness;
    }
}