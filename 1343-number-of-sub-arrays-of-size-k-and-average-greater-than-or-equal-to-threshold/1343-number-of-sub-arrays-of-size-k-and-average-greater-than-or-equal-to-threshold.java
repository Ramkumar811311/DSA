class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < arr.length) {
            sum += arr[r];
            if (r - l + 1 > k) {
                sum -= arr[l];
                l++;
            }

            if (r - l + 1 == k && sum / k>=threshold) {
                ans++;
            }
            r++;
        }
        return ans;
    }
}