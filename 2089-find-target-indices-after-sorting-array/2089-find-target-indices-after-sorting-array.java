class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        int countSmall = 0;
        int countTarget=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<target){
                countSmall++;
            }
            if(nums[i]==target){
                countTarget++;
            }
        }
        int start=countSmall;
        int end=countSmall+countTarget;
        for(int i=start; i<end; i++){
            ans.add(i);
        }
        return ans;
    }
}