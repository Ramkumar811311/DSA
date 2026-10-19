class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0;
        long ans = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            sum+=nums[r];

            while (sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}