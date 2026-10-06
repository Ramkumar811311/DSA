class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0){
            return false;
        }
        int i = 0;
        int j = 1;
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        while (j < nums.length) {
            int diffInd = Math.abs(i - j);
            if (diffInd > k && i < j) {
                set.remove(nums[i]);
                i++;
                diffInd = Math.abs(i - j);
            }
            if (set.contains(nums[j])) {
                return true;
            }
            set.add(nums[j]);
            j++;
        }
        return false;
    }
}