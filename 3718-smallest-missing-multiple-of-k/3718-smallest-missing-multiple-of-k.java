class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=k;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        while(true){
            if(!set.contains(n)){
                return n;
            }
            n+=k;
        }
    }
}