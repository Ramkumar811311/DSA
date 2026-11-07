class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        int score = 0;
        int maxscore = 0;
        int freq[] = new int[10001];
        while (r < nums.length) {
            score += nums[r];
            while (freq[nums[r]] == 1) {
                freq[nums[l]]--;
                score -= nums[l];
                l++;
            }
            freq[nums[r]]++;
            maxscore = Math.max(score, maxscore);
            r++;
        }
        return maxscore;
    }
}