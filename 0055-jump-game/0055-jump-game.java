class Solution {
    public boolean canJump(int[] nums) {
        int maxRechableInd = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > maxRechableInd) {
                return false;
            }
            int maxJump = i + nums[i];
            maxRechableInd = Math.max(maxJump, maxRechableInd);
        }
        return true;
    }
}