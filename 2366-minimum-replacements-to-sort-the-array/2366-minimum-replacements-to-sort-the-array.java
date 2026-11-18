class Solution {
    public long minimumReplacement(int[] nums) {
        int maxValue = nums[nums.length - 1];
        long operation = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > maxValue) {
                int part = nums[i] / maxValue;
                if (nums[i] % maxValue != 0) {
                    part++;
                }
                operation += part - 1;
                maxValue = nums[i] / part;
            } else {
                maxValue = nums[i];
            }
        }
        return operation;
    }
}