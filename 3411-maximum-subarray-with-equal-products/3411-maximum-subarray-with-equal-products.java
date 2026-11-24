
class Solution {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return (a / gcd((int)a, (int)b)) * b;
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            long product = 1;
            long LCM = 1;
            int GCD = 0;

            for (int j = i; j < n; j++) {
                product *= nums[j];

                GCD = gcd(GCD, nums[j]);
                LCM = lcm(LCM, nums[j]);

                if (product == GCD * LCM) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}
