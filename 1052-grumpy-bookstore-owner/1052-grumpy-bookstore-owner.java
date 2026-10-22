class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int maxSatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                maxSatisfied += customers[i];
            }
        }
        int maxAdditional = 0;
        int l = 0;
        int r = 0;
        int windowSum = 0;
        while (r < n) {
            if (grumpy[r] == 1) {
                windowSum += customers[r];
            }

            if (r - l + 1 > minutes) {
                if (grumpy[l] == 1) {
                    windowSum -= customers[l];
                }
                l++;
            }

            if (r - l + 1 == minutes) {
                maxAdditional = Math.max(maxAdditional, windowSum);
            }
            r++;

        }
        return maxSatisfied+maxAdditional;
    }
}