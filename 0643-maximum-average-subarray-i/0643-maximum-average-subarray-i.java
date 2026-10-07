class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        int  sumOfkElement = 0;
        while (r < nums.length) {
            sumOfkElement += nums[r];
            if (r - l + 1 > k) {
                sumOfkElement -= nums[l];
                l++;
            }
            if (r - l + 1 == k) {
              maxSum=Math.max(maxSum,sumOfkElement);
            }
            r++;
        }
        double maxAvg = (double)maxSum/k;
        return maxAvg;
    }
}