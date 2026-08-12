class Solution {
    public int maxSubarrayLength(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int maxlen = 0;

        while (r < arr.length) {
            if (map.containsKey(arr[r])) {
                map.put(arr[r], map.get(arr[r]) + 1);
            } else {
                map.put(arr[r], 1);
            }

            while (map.get(arr[r]) > k) {
                map.put(arr[l], map.get(arr[l]) - 1);
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }

        return maxlen;
    }
}