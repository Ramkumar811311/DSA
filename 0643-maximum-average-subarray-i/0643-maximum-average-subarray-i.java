class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;
        int l = 0;
        int r = 0;
        double sumOfkElement = 0;
        while (r < nums.length) {
            if (r - l + 1 > k) {
                sumOfkElement -= nums[l];
                l++;
            }
            sumOfkElement += nums[r];
            if (r - l + 1 == k) {
                double avg = sumOfkElement / k;
                maxAvg = Math.max(avg, maxAvg);
            }
            r++;
        }
        return maxAvg;
    }
}