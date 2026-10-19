class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
        int product=1;
        int ans=0;
        int l=0;
        int r=0;
        while(r<nums.length){
            product*=nums[r];
            while(product>=k){
                product/=nums[l];
                l++;
            }
            ans+=r-l+1;
            r++;
        }
        return ans;
    }
}