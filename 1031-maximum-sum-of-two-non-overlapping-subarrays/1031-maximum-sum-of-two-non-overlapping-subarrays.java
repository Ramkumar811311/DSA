class Solution {
    public static int findBestSum(int L, int M, int nums[]) {
        int n = nums.length;

        int sumL = 0;
        int sumM = 0;

        for (int i = 0; i < L; i++) {
            sumL += nums[i];
        }

        for (int i = L; i < L + M; i++) {
            sumM += nums[i];
        }
        int bestL = sumL;
        int bestSum = sumL + sumM;

        for (int i = L + M; i < n; i++) {
            sumL += nums[i - M] - nums[i - M - L];
            sumM += nums[i] - nums[i - M];
            bestL = Math.max(sumL, bestL);
            bestSum = Math.max(bestSum, bestL + sumM);
        }

        return bestSum;
    }

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int ans = Math.max(
                findBestSum(firstLen, secondLen, nums),
                findBestSum(secondLen, firstLen, nums));

        return ans;
    }
}