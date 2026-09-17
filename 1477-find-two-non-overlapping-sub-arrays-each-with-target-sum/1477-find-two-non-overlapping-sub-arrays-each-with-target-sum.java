class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int l = 0;
        int r = 0;
        int ans = Integer.MAX_VALUE;
        int best = Integer.MAX_VALUE;
        int minBestLenTillIdx[] = new int[arr.length];
        Arrays.fill(minBestLenTillIdx, Integer.MAX_VALUE);
        int sum = 0;
        while (r < arr.length) {
            sum += arr[r];
            while (sum > target && l <= r) {
                sum -= arr[l];
                l++;
            }

            if (sum == target) {
                int len = r - l + 1;
                if (l > 0 && minBestLenTillIdx[l - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + minBestLenTillIdx[l - 1]);
                }
                best = Math.min(best, len);
            }

            minBestLenTillIdx[r] = best;

            r++;

        }
        return ans==Integer.MAX_VALUE ? -1: ans;
    }
}