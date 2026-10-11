class Solution {
    public int minimumRecolors(String blocks, int k) {
        int countW=0;
        int minW=Integer.MAX_VALUE;
        int l=0;
        int r=0;
        while(r<blocks.length()){
            char ch = blocks.charAt(r);
            if(ch=='W'){
                countW++;
            }
            if(r-l+1>k){
                if(blocks.charAt(l)=='W'){
                    countW--;
                }
                l++;
            }
            if(r-l+1==k){
                minW=Math.min(minW,countW);
            }
            r++;
        }
        return minW;
    }
}