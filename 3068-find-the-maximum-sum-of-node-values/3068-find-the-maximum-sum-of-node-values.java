class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int minNuksaan = Integer.MAX_VALUE;
        int count = 0;
        long maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int xor = nums[i] ^ k;
            if (xor > nums[i]) {
                maxSum += nums[i] ^ k;
                count++;
            } else {
                maxSum += nums[i];
            }
            minNuksaan = Math.min(minNuksaan, Math.abs(nums[i]-xor));
        }
        return count % 2 == 0 ? maxSum : maxSum - minNuksaan;
    }
}