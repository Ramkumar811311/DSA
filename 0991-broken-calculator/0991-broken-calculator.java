class Solution {
    public int brokenCalc(int startValue, int target) {
        int minOp = 0;

        while (startValue != target) {
            if (target>startValue && target % 2 == 0) {
                target /= 2;
            } else {
                target += 1;
            }
            minOp++;
        }
        return minOp;
    }
}