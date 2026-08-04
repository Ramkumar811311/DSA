class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
            set.add(nums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=min+1; i<max; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}