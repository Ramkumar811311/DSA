class Solution {
    public long largestPerimeter(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            sum -= nums[i];
            if (nums[i] < sum) {
                return sum + nums[i];
            }
        }
        return -1;
    }
}