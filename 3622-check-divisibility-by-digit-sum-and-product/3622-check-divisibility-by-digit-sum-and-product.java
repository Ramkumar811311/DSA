class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int mul=1;
        int num=n;
        while(num!=0){
            int digit=num%10;
            sum+=digit;
            mul*=digit;
            num=num/10;
        }
        return n%(sum+mul)==0;
    }
}