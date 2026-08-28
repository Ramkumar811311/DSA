class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=k;
        Arrays.sort(nums);
        while(true){
            boolean found=false;
            for(int i=0; i<nums.length; i++){
                if(n==nums[i]){
                    found=true;
                }
            }
            if(found==false){
                return n;
            }
            n+=k;
        }
       
    }
}