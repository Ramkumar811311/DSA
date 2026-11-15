class Solution {
    public int maximum69Number(int num) {
        int n = num;
        int counter = 0;
        int pv = -1;
        while (n != 0) {
            int digit = n % 10;
            n /= 10;
            if (digit == 6) {
                pv = counter;
            }
            counter++;
        }
        if(pv==-1){
            return num;
        }

        int maxValue = (int) (num + (3 * Math.pow(10, pv)));
        return maxValue;
    }
}