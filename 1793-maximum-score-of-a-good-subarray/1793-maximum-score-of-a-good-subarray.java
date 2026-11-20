class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int i = k;
        int j = k;
        int currMin = nums[k];
        int maxScore = nums[k];
        while (i > 0 || j < n - 1) {
            int leftValue = (i > 0) ? nums[i - 1] : 0;
            int rightValue = (j < n - 1) ? nums[j + 1] : 0;
            if (rightValue > leftValue) {
                currMin = Math.min(currMin, rightValue);
                j++;
            } else {
                currMin = Math.min(currMin, leftValue);
                i--;
            }

            maxScore = Math.max(maxScore, currMin * (j - i + 1));
        }
        return maxScore;
    }
}