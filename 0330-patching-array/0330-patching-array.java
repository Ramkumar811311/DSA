class Solution {
    public int minPatches(int[] nums, int n) {
        long maxRechable = 0;
        int patch = 0;
        int i = 0;
        while (maxRechable < n) {
            if (i<nums.length && nums[i] <= maxRechable + 1) {
                maxRechable += nums[i];
                i++;
            }else{
                patch++;
                maxRechable+=(maxRechable+1);
            }
        }
        return patch;
    }
}