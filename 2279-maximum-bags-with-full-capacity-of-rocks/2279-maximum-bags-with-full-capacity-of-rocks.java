class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int maxFillBags = 0;
        Integer required[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            required[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(required);
        for (int i = 0; i < n; i++) {
            if (additionalRocks >= required[i]) {
                additionalRocks -= required[i];
                maxFillBags++;
            } else {
                break;
            }
        }
        return maxFillBags;
    }
}