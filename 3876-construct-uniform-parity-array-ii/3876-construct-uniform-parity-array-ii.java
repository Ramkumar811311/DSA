class Solution {
    public boolean uniformArray(int[] nums1) {
        int s_oddNo=Integer.MAX_VALUE;
        int s_evenNo=Integer.MAX_VALUE;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==0){
                s_evenNo=Math.min(s_evenNo,nums1[i]);
            }else{
                s_oddNo=Math.min(s_oddNo,nums1[i]);
            }
        }
        if(s_oddNo==Integer.MAX_VALUE){
            return true;
        }
        if(s_evenNo==Integer.MAX_VALUE){
            return true;
        }
        
        if(s_evenNo<s_oddNo){
            return false;
        }
       return true;
    }
}