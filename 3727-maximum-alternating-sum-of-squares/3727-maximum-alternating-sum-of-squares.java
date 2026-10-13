class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long maxAns = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            if (l == r) {
                maxAns += 1L * nums[l] * nums[l];

                break;
            }
            maxAns += (nums[r] * nums[r] - nums[l] * nums[l]);
            l++;
            r--;
        }
        return maxAns;
    }
}