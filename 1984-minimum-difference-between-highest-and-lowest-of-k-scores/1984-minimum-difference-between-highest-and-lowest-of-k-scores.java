class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        int ans = Integer.MAX_VALUE;
        while (r < nums.length) {
            if (r - l + 1 > k) {
                l++;
            }
            if (r - l + 1 == k) {
                ans = Math.min(ans, nums[r] - nums[l]);
            }
            r++;
        }
        return ans;
    }
}