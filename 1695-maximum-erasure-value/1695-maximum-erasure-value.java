class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        int score = 0;
        int maxscore = 0;
        HashSet<Integer> set = new HashSet<>();
        while (r < nums.length) {
            score += nums[r];
            while (!set.isEmpty() && set.contains(nums[r])) {
                set.remove(nums[l]);
                score -= nums[l];
                l++;
            }
            set.add(nums[r]);
            maxscore = Math.max(score, maxscore);
            r++;
        }
        return maxscore;
    }
}