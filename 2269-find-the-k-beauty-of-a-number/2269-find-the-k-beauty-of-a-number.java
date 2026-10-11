class Solution {
    public int divisorSubstrings(int num, int k) {
        int n=0;
        int ans=0;
        int l=0;
        int r=0;
        String s = Integer.toString(num);
        while(r<s.length()){
            char ch=s.charAt(r);
            int digit = ch-'0';
            n=n*10+digit;
            if(r-l+1>k){
                int divisor = (int) Math.pow(10, k);
               n%=divisor;
               l++;
            }
            if(r-l+1==k && n!=0 && num%n==0){
                ans++;
            }
            r++;
        }
        return ans;
    }
}