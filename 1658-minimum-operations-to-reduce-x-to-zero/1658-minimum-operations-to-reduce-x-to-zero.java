class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int element : nums) {
            sum += element;
        }
        int target = sum - x;
        if (target == 0) {
            return n;
        }
        if (target < 0) {
            return -1;
        }
        int maxlen = 0;
        int l = 0;
        int r = 0;
        int sum1 = 0;
        while (r < n) {
            sum1 += nums[r];
            while (l <= r && sum1 > target) {
                sum1 -= nums[l];
                l++;
            }

            if (sum1 == target) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r++;
        }

        if (maxlen == 0) {
            return -1;
        }
        int ans = n - maxlen;
        return ans;
    }
}