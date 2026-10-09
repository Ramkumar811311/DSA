class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = k - 1;
        int ans = Integer.MAX_VALUE;
        while (j < nums.length) {

            ans = Math.min(ans, nums[j] - nums[i]);
            i++;
            j++;
        }
        return ans;
    }
}